package com.hatshop_api.controllers

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

/**
 * Test for DepartmentController
 * Created by luis on 7/9/15.
 */
@SpringBootTest
@AutoConfigureMockMvc
class CategoryControllerAndDepartmentControllerTest @Autowired constructor(
  val mockMvc: MockMvc
) {

  @Test
  @Throws(Exception::class)
  fun `should return Products in Department 2`() {
    mockMvc.get("/api/departments/2/products") {
      accept(MediaType.APPLICATION_JSON)

    }.andExpect {
      status { isOk() }
      content {
        json(
          """{
  "totalElements": 8,
  "pageNumber": 0,
  "totalPages": 1,
  "content": [
    {
      "description": "Uniform Chauffeur Cap. This cap is the real thing. Well-made and professional looking, our Chauffeur hat gets so many compliments from our customers who buy (and wear) them. It's absolutely amazing how many of these we sell. One thing's for sure, this authentic professional cap will let everyone know exactly who's in the driver's seat. So ... whether you're driving Miss Daisy ... or driving yourself crazy ... I'll bet your wife will coo and purr ... when she sees you in our authentic chauffer!",
      "discountedPrice": 0,
      "display": 0,
      "id": 8,
      "image": "ChauffeurHat.jpg",
      "name": "Chauffeur Hat",
      "price": 70,
      "thumbnail": "ChauffeurHat.thumb.jpg"
    },
    {
      "description": "This is our tried and true men's classic beret hat(tam). Our Basque beret is superbly crafted, 100% wool, and has a comfortable leather sweatband. Lined and water resistant, the beret is great for everyday wear and rolls up nicely to fit in your pocket. So ... if you're antsy ... in your pantsy ... cause you wanna catch the fancy ... of the lady near your way ... then please don't delay ... just get this beret ... today ... and soon you'll be making hay!",
      "discountedPrice": 0,
      "display": 0,
      "id": 23,
      "image": "BlackBasqueBeret.jpg",
      "name": "Black Basque Beret",
      "price": 50,
      "thumbnail": "BlackBasqueBeret.thumb.jpg"
    },
    {
      "description": "The Parkhurst SunGuard line of headwear offers the comfort and breathability of cotton and provides up to 50 times your natural protection from the sun's rays. Fashionable, durable, and washable, Sunguard is the only choice.",
      "discountedPrice": 8,
      "display": 2,
      "id": 24,
      "image": "CottonBeret.jpg",
      "name": "Cotton Beret",
      "price": 13,
      "thumbnail": "CottonBeret.thumb.jpg"
    },
    {
      "description": "This classic tam from Kangol is one size fits all. It's composed of 100% wool and measures 11\" in diameter.",
      "discountedPrice": 0,
      "display": 0,
      "id": 25,
      "image": "WoolBeret.jpg",
      "name": "Wool Beret",
      "price": 25,
      "thumbnail": "WoolBeret.thumb.jpg"
    },
    {
      "description": "As one of our best selling berets, this Black Military Beret is especially popular in these war-torn days. Made of wool felt, it's a facsimile of what Monty wore in the deserts of Africa in World War II. We don't guarantee any sweeping victories with this beret, but you might score a personal triumph or two!",
      "discountedPrice": 13,
      "display": 3,
      "id": 26,
      "image": "MilitaryBeret.jpg",
      "name": "Military Beret",
      "price": 20,
      "thumbnail": "MilitaryBeret.thumb.jpg"
    },
    {
      "description": "Leather was never so stylish. The Bond-Driver has an elastic sweatband for a sure fit. Seamed and unlined, this driver is perfect for cruising around town or saving the world.",
      "discountedPrice": 0,
      "display": 0,
      "id": 27,
      "image": "Bond-LeatherDriver.jpg",
      "name": "Bond-Leather Driver",
      "price": 50,
      "thumbnail": "Bond-LeatherDriver.thumb.jpg"
    },
    {
      "description": "This quality ivy cap made by Christy's comes with a finished lining. The material of this ivy is called moleskin and is very soft. If your life's kinda in a hole ... and you wish you had a little more soul ... no need to beat your head against a pole, Ken ... just purchase our Christy's Ivy Cap in Moleskin!",
      "discountedPrice": 25,
      "display": 2,
      "id": 28,
      "image": "MoleskinDriver.jpg",
      "name": "Moleskin Driver",
      "price": 30,
      "thumbnail": "MoleskinDriver.thumb.jpg"
    },
    {
      "description": "Herringbone is everywhere this year from head to toe. The English Driver ivy cap is made of wool with a cotton sweatband on the inside.",
      "discountedPrice": 0,
      "display": 0,
      "id": 29,
      "image": "HerringboneEnglishDriver.jpg",
      "name": "Herringbone English Driver",
      "price": 30,
      "thumbnail": "HerringboneEnglishDriver.thumb.jpg"
    }
  ]
}"""
        )
      }
    }
  }

  @Test
  @Throws(Exception::class)
  fun `should return Categories in Department 2`() {
    mockMvc.get("/api/departments/2/categories") {
      accept(MediaType.APPLICATION_JSON)

    }.andExpect {
      status { isOk() }
      content {
        json(
          """{
  "totalElements": 2,
  "pageNumber": 0,
  "totalPages": 1,
  "content": [
    {
      "department": {
        "id": 2
      },
      "description": "An amazing collection of berets from all around the world!",
      "id": 4,
      "name": "Berets"
    },
    {
      "department": {
        "id": 2
      },
      "description": "Be an original driver! Buy a driver's hat today!",
      "id": 5,
      "name": "Driving Caps"
    }
  ]
}"""
        )
      }
    }
  }

  @Test
  @Throws(Exception::class)
  fun `should return Products in Category 2`() {
    mockMvc.get("/api/categories/2/products") {
      accept(MediaType.APPLICATION_JSON)

    }.andExpect {
      status { isOk() }
      content {
        json(
          """{
  "totalElements": 8,
  "pageNumber": 0,
  "totalPages": 1,
  "content": [
    {
      "description": "Uniform Chauffeur Cap. This cap is the real thing. Well-made and professional looking, our Chauffeur hat gets so many compliments from our customers who buy (and wear) them. It's absolutely amazing how many of these we sell. One thing's for sure, this authentic professional cap will let everyone know exactly who's in the driver's seat. So ... whether you're driving Miss Daisy ... or driving yourself crazy ... I'll bet your wife will coo and purr ... when she sees you in our authentic chauffer!",
      "discountedPrice": 0,
      "display": 0,
      "id": 8,
      "image": "ChauffeurHat.jpg",
      "name": "Chauffeur Hat",
      "price": 70,
      "thumbnail": "ChauffeurHat.thumb.jpg"
    },
    {
      "description": "We're not sure what the Vatican's official position is on this hat, but we do know your friends will love you in this soft velour hat with gold lame accents. If you're somewhat lacking in religion ... if you're looking for some hope ... you might acquire just a smidgeon ... by faithfully wearing our Pope!",
      "discountedPrice": 0,
      "display": 0,
      "id": 9,
      "image": "ThePopeHat.jpg",
      "name": "The Pope Hat",
      "price": 30,
      "thumbnail": "ThePopeHat.thumb.jpg"
    },
    {
      "description": "A hat that channels the 70s. This oversized vinyl cap with silver badge will make you a charter member of the disco era ... or is that disco error?",
      "discountedPrice": 0,
      "display": 0,
      "id": 10,
      "image": "VinylPolicemanCopHat.jpg",
      "name": "Vinyl Policeman Cop Hat",
      "price": 30,
      "thumbnail": "VinylPolicemanCopHat.thumb.jpg"
    },
    {
      "description": "Our burgundy Kings Crown is one size fits all. This crown is adorned with gold ribbon, gems, and a faux-fur headband. Be King for a Day ... Finally get your say ... Put your foot down ... and do it with humor, wearing our Elegant Burgundy King's Crown!",
      "discountedPrice": 26,
      "display": 2,
      "id": 11,
      "image": "BurgandyKingsCrown.jpg",
      "name": "Burgundy Kings Crown",
      "price": 35,
      "thumbnail": "BurgandyKingsCrown.thumb.jpg"
    },
    {
      "description": "Our wool felt Pirate Hat comes with the front and back brims turned upward. This sized hat has the pirate emblem on the front. So, ho, ho, ho and a bottle of rum ... if you're about as crazy as they come ... wear our Pirate hat this coming Halloween ... and with an eyepatch to boot, you'll be lusty, lean and mean!",
      "discountedPrice": 0,
      "display": 0,
      "id": 12,
      "image": "454BlackPirateHat.jpg",
      "name": "454 Black Pirate Hat",
      "price": 40,
      "thumbnail": "454BlackPirateHat.thumb.jpg"
    },
    {
      "description": "Haentze Hatcrafters has been making quality theatrical and military headgear for decades. Each hat is made meticulously by hand with quality materials. Many of these hats have been used in movies and historical reproductions and re-enactments.",
      "discountedPrice": 76,
      "display": 2,
      "id": 13,
      "image": "BlackPuritanHat.jpg",
      "name": "Black Puritan Hat",
      "price": 90,
      "thumbnail": "BlackPuritanHat.thumb.jpg"
    },
    {
      "description": "Professor McGonagall, Deputy Headmistress of Hogwarts and Head of Gryffindor House, commands respect in this dramatic witch hat - and so will you! The inside of this hat has a touch fastener size-adjustment tab. The hat is a must for all Harry Potter fans!",
      "discountedPrice": 0,
      "display": 0,
      "id": 14,
      "image": "ProfessorMcGonagallWitchHat.jpg",
      "name": "Professor McGonagall Witch Hat",
      "price": 25,
      "thumbnail": "ProfessorMcGonagallWitchHat.thumb.jpg"
    },
    {
      "description": "This cool Merlin-style wizard hat by Elope has a dragon that lays around the whole hat. The wizard hat is one size fits all and has a touch fastener on the inside to adjust accordingly.",
      "discountedPrice": 0,
      "display": 0,
      "id": 15,
      "image": "BlackWizardHat.jpg",
      "name": "Black Wizard Hat",
      "price": 35,
      "thumbnail": "BlackWizardHat.thumb.jpg"
    }
  ]
}"""
        )
      }
    }
  }

}
