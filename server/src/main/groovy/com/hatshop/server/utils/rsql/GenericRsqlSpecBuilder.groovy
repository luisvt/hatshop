package com.hatshop.server.utils.rsql

import cz.jirutka.rsql.parser.ast.ComparisonNode
import cz.jirutka.rsql.parser.ast.LogicalNode
import cz.jirutka.rsql.parser.ast.LogicalOperator
import cz.jirutka.rsql.parser.ast.Node
import org.springframework.data.jpa.domain.Specification

class GenericRsqlSpecBuilder<T> {

    Specification<T> createSpecification(Node node) {
        if (node instanceof LogicalNode) {
            return createSpecification((LogicalNode) node)
        }
        if (node instanceof ComparisonNode) {
            return createSpecification((ComparisonNode) node)
        }
        return null
    }

    Specification<T> createSpecification(LogicalNode logicalNode) {
        def specs = logicalNode.children
                .collect { node -> createSpecification(node) }
                .findAll Objects.&nonNull

        Specification<T> result = specs[0]
        if (logicalNode.getOperator() == LogicalOperator.AND) {
            for (int i = 1; i < specs.size(); i++) {
                result = Specification.where(result).and(specs.get(i))
            }
        } else if (logicalNode.getOperator() == LogicalOperator.OR) {
            for (int i = 1; i < specs.size(); i++) {
                result = Specification.where(result).or(specs.get(i))
            }
        }

        return result
    }

    Specification<T> createSpecification(ComparisonNode comparisonNode) {
        Specification.where(
                new GenericRsqlSpecification<T>(
                        comparisonNode.getSelector(),
                        comparisonNode.getOperator(),
                        comparisonNode.getArguments()
                )
        )
    }
}
