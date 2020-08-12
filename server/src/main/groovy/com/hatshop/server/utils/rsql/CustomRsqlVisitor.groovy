package com.hatshop.server.utils.rsql

import cz.jirutka.rsql.parser.ast.AndNode
import cz.jirutka.rsql.parser.ast.ComparisonNode
import cz.jirutka.rsql.parser.ast.OrNode
import cz.jirutka.rsql.parser.ast.RSQLVisitor
import org.springframework.data.jpa.domain.Specification

class CustomRsqlVisitor<T> implements RSQLVisitor<Specification<T>, Void> {

    private GenericRsqlSpecBuilder<T> builder = new GenericRsqlSpecBuilder<T>()

    @Override
    Specification<T> visit(AndNode node, Void param) {
        return builder.createSpecification(node)
    }

    @Override
    Specification<T> visit(OrNode node, Void param) {
        return builder.createSpecification(node)
    }

    @Override
    Specification<T> visit(ComparisonNode node, Void params) {
        return builder.createSpecification(node)
    }
}
