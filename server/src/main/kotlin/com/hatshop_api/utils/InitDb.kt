package com.hatshop_api.utils

import com.hatshop_api.models.Category
import com.hatshop_api.models.Customer
import com.hatshop_api.models.Department
import com.hatshop_api.models.Product
import com.hatshop_api.models.Shipping
import com.hatshop_api.models.ShippingRegion
import com.hatshop_api.models.Tax
import com.hatshop_api.repositories.CategoryRepository
import com.hatshop_api.repositories.CustomerRepository
import com.hatshop_api.repositories.DepartmentRepository
import com.hatshop_api.repositories.ProductRepository
import com.hatshop_api.repositories.ShippingRegionRepository
import com.hatshop_api.repositories.ShippingRepository
import com.hatshop_api.repositories.TaxRepository
import com.hatshop_api.security.models.EUser
import com.hatshop_api.security.models.Role
import com.hatshop_api.security.repositories.RoleRepository
import com.hatshop_api.security.repositories.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@Profile("default", "dev")
class InitDb(
  val userRepository: UserRepository,
  val customerRepository: CustomerRepository,
  val shippingRegionRepository: ShippingRegionRepository,
  val departmentRepository: DepartmentRepository,
  val categoryRepository: CategoryRepository,
  val productRepository: ProductRepository,
  val shippingRepository: ShippingRepository,
  val taxRepository: TaxRepository,
  val roleRepository: RoleRepository,
  val encoder: PasswordEncoder
) : CommandLineRunner {

  override fun run(vararg args: String?) {

    val dep1 = Department("Holiday", "Prepare for the holidays with our special collection of seasonal hats!")
    val dep2 = Department("Caps and Berets", "The perfect hats to wear at work and costume parties!")
    val dep3 = Department("Costume Hats", "Find the matching hat for your costume!")
    departmentRepository.saveAll(listOf(dep1, dep2, dep3))

    val cat1 = Category(dep1, "Christmas Hats", "Enjoy browsing our collection of Christmas hats!")
    val cat2 = Category(dep1, "Halloween Hats", "Find the hat you'll wear this Halloween!")
    val cat3 = Category(dep1, "St. Patrick's Day Hats", "Try one of these beautiful hats on St. Patrick's Day!")
    val cat4 = Category(dep2, "Berets", "An amazing collection of berets from all around the world!")
    val cat5 = Category(dep2, "Driving Caps", "Be an original driver! Buy a driver's hat today!")
    val cat6 =
      Category(dep3, "Theatrical Hats", "Going to a costume party? Try one of these hats to complete your costume!")
    val cat7 = Category(dep3, "Military Hats", "This collection contains the most realistic replicas of military hats!")
    categoryRepository.saveAll(listOf(cat1, cat2, cat3, cat4, cat5, cat6, cat7))

    val prod1 = Product(
      "Christmas Candy Hat",
      "Be everyone's \"sweetie\" while wearing this fun and festive peppermint candy hat. The Christmas Candy hat, made by Elope, stands about 15 inches tall and has a sizing adjustment on the inside.",
      24.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ChristmasCandyHat.jpg",
      "ChristmasCandyHat.thumb.jpg",
      0,
      mutableSetOf(cat1)
    )
    val prod2 = Product(
      "Hanukah Hat",
      "The Hanukah hat is a fun and festive way for you to enjoy yourself during the holiday. Made by Elope and adorned with 9 candles, this menorah is sure to brighten the winter celebration.",
      24.99.toBigDecimal(),
      21.99.toBigDecimal(),
      "HanukahHat.jpg",
      "HanukahHat.thumb.jpg",
      2,
      mutableSetOf(cat1)
    )
    val prod3 = Product(
      "Springy Santa Hat",
      "Santa Hat - Boing-Boing-Boing. Santa will be springing into town with this outrageous cap! If your children are whiney and clingy ... and your head's going ping-pong-pingy ... and you feel like just rowing away in your rubber dinghy ... Take heart! You'll bounce bounce back ... if you just put on our Santa hat that's Springy!",
      19.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "SpringySantaHat.jpg",
      "SpringySantaHat.thumb.jpg",
      0,
      mutableSetOf(cat1)
    )
    val prod4 = Product(
      "Plush Santa Hat",
      "Get into the spirit of the season with this plush, velvet-like, Santa hat. Comes in a beautiful crimson red color with a faux-fur trim.",
      12.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "PlushSantaHat.jpg",
      "PlushSantaHat.thumb.jpg",
      0,
      mutableSetOf(cat1)
    )
    val prod5 = Product(
      "Red Santa Cowboy Hat",
      "This velvet Cowboy Santa Hat is one size fits all and has white faux-fur trim all around. Here comes Santa Claus ... Here comes Santa Claus ... right down Cowboy Lane!",
      24.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "RedSantaCowboyHat.jpg",
      "RedSantaCowboyHat.thumb.jpg",
      0,
      mutableSetOf(cat1)
    )
    val prod6 = Product(
      "Santa Jester Hat",
      "This three-prong velvet jester is one size fits all and has an adjustable touch fastener back for perfect fitting.",
      24.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "SantaJesterHat.jpg",
      "SantaJesterHat.thumb.jpg",
      0,
      mutableSetOf(cat1)
    )
    val prod7 = Product(
      "Santa's Elf Hat",
      "Be Santa's best looking helper with this velvet hat, complete with attached ears. So, if you don't wanna be yourself ... don't worry ... this Christmas, just be Santa's elf! Happy Holidays!",
      24.99.toBigDecimal(),
      16.95.toBigDecimal(),
      "Santa'sElfHat.jpg",
      "Santa'sElfHat.thumb.jpg",
      1,
      mutableSetOf(cat1)
    )
    val prod8 = Product(
      "Chauffeur Hat",
      "Uniform Chauffeur Cap. This cap is the real thing. Well-made and professional looking, our Chauffeur hat gets so many compliments from our customers who buy (and wear) them. It's absolutely amazing how many of these we sell. One thing's for sure, this authentic professional cap will let everyone know exactly who's in the driver's seat. So ... whether you're driving Miss Daisy ... or driving yourself crazy ... I'll bet your wife will coo and purr ... when she sees you in our authentic chauffer!",
      69.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ChauffeurHat.jpg",
      "ChauffeurHat.thumb.jpg",
      0,
      mutableSetOf(cat2, cat5)
    )
    val prod9 = Product(
      "The Pope Hat",
      "We're not sure what the Vatican's official position is on this hat, but we do know your friends will love you in this soft velour hat with gold lame accents. If you're somewhat lacking in religion ... if you're looking for some hope ... you might acquire just a smidgeon ... by faithfully wearing our Pope!",
      29.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ThePopeHat.jpg",
      "ThePopeHat.thumb.jpg",
      0,
      mutableSetOf(cat2)
    )
    val prod10 = Product(
      "Vinyl Policeman Cop Hat",
      "A hat that channels the 70s. This oversized vinyl cap with silver badge will make you a charter member of the disco era ... or is that disco error?",
      29.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "VinylPolicemanCopHat.jpg",
      "VinylPolicemanCopHat.thumb.jpg",
      0,
      mutableSetOf(cat2)
    )
    val prod11 = Product(
      "Burgundy Kings Crown",
      "Our burgundy Kings Crown is one size fits all. This crown is adorned with gold ribbon, gems, and a faux-fur headband. Be King for a Day ... Finally get your say ... Put your foot down ... and do it with humor, wearing our Elegant Burgundy King's Crown!",
      34.99.toBigDecimal(),
      25.95.toBigDecimal(),
      "BurgandyKingsCrown.jpg",
      "BurgandyKingsCrown.thumb.jpg",
      2,
      mutableSetOf(cat2)
    )
    val prod12 = Product(
      "454 Black Pirate Hat",
      "Our wool felt Pirate Hat comes with the front and back brims turned upward. This sized hat has the pirate emblem on the front. So, ho, ho, ho and a bottle of rum ... if you're about as crazy as they come ... wear our Pirate hat this coming Halloween ... and with an eyepatch to boot, you'll be lusty, lean and mean!",
      39.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "454BlackPirateHat.jpg",
      "454BlackPirateHat.thumb.jpg",
      0,
      mutableSetOf(cat2)
    )
    val prod13 = Product(
      "Black Puritan Hat",
      "Haentze Hatcrafters has been making quality theatrical and military headgear for decades. Each hat is made meticulously by hand with quality materials. Many of these hats have been used in movies and historical reproductions and re-enactments.",
      89.99.toBigDecimal(),
      75.99.toBigDecimal(),
      "BlackPuritanHat.jpg",
      "BlackPuritanHat.thumb.jpg",
      2,
      mutableSetOf(cat2)
    )
    val prod14 = Product(
      "Professor McGonagall Witch Hat",
      "Professor McGonagall, Deputy Headmistress of Hogwarts and Head of Gryffindor House, commands respect in this dramatic witch hat - and so will you! The inside of this hat has a touch fastener size-adjustment tab. The hat is a must for all Harry Potter fans!",
      24.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ProfessorMcGonagallWitchHat.jpg",
      "ProfessorMcGonagallWitchHat.thumb.jpg",
      0,
      mutableSetOf(cat2)
    )
    val prod15 = Product(
      "Black Wizard Hat",
      "This cool Merlin-style wizard hat by Elope has a dragon that lays around the whole hat. The wizard hat is one size fits all and has a touch fastener on the inside to adjust accordingly.",
      34.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "BlackWizardHat.jpg",
      "BlackWizardHat.thumb.jpg",
      0,
      mutableSetOf(cat2)
    )
    val prod16 = Product(
      "Leprechaun Hat",
      "Show them the green! This hand-blocked, wool felt hat will make you the hit of this year's St. Paddy's Day Celebration! Oh yes, the green you will don ... and what better way, hon ... than if this St. Patrick's Day ... you're wearing our cool Leprechaun!",
      88.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "LeprechaunHat.jpg",
      "LeprechaunHat.thumb.jpg",
      0,
      mutableSetOf(cat3)
    )
    val prod17 = Product(
      "9 Green MadHatter Top Hat",
      "Each of our MadHatter hats is made meticulously by hand with quality materials. Many of these hats have been used in movies and historical reproductions and re-enactments.",
      149.99.toBigDecimal(),
      124.95.toBigDecimal(),
      "9GreenMadHatterTopHat.jpg",
      "9GreenMadHatterTopHat.thumb.jpg",
      2,
      mutableSetOf(cat3)
    )
    val prod18 = Product(
      "Winter Walking Hat",
      "Our declarative English walking hat by Christy's of London comes in 100% Lana Wool and reveals a finished satin lining. Christy's has been making hats since 1773 and knows how to make the best! Want proof? Try this one ... Irish eyes will be smiling.",
      49.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "WinterWalkingHat.jpg",
      "WinterWalkingHat.thumb.jpg",
      0,
      mutableSetOf(cat3)
    )
    val prod19 = Product(
      "Green MadHatter Hat",
      "St. Patrick's Day Hat - Luck o' the Irish! This oversized green velveteen MadHatter is great for St.Patrick's day or a MadHatter's tea party.One size fits most adults.",
      39.99.toBigDecimal(),
      28.99.toBigDecimal(),
      "GreenMadHatterHat.jpg",
      "GreenMadHatterHat.thumb.jpg",
      2,
      mutableSetOf(cat3)
    )
    val prod20 = Product(
      "Hole in One Golf Costume Hat",
      "Golf Hat - OK, Ace. This spoof golfer's hat sports an astro-turf \"green,\" has an attached golf ball and flag, and includes a soft elastic band  for comfort. This hat also makes a great gift that is definitely \"up to par\" for any goofball's - uh - golfballer's taste. Perfect for Dad! And don't you fore-get-it!",
      29.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "HoleinOneGolfCostumeHat.jpg",
      "HoleinOneGolfCostumeHat.thumb.jpg",
      0,
      mutableSetOf(cat3)
    )
    val prod21 = Product(
      "Luck of the Irish Bowler",
      "This one size fits all Irish Derby comes with a shamrock attached to the side. This hat is made of a soft velvet and is comfortably sized.",
      29.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "LuckoftheIrishBowler.jpg",
      "LuckoftheIrishBowler.thumb.jpg",
      0,
      mutableSetOf(cat3)
    )
    val prod22 = Product(
      "St. Patrick's Irish Green Derby",
      "This quality bowler will last you more than one St. Patrick's Day! A proper derby for the day, it is made of wool felt and has a green grosgrain band. This hat is not lined.",
      39.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "St.Patrick'sIrishGreenDerby.jpg",
      "St.Patrick'sIrishGreenDerby.thumb.jpg",
      0,
      mutableSetOf(cat3)
    )
    val prod23 = Product(
      "Black Basque Beret",
      "This is our tried and true men's classic beret hat(tam). Our Basque beret is superbly crafted, 100% wool, and has a comfortable leather sweatband. Lined and water resistant, the beret is great for everyday wear and rolls up nicely to fit in your pocket. So ... if you're antsy ... in your pantsy ... cause you wanna catch the fancy ... of the lady near your way ... then please don't delay ... just get this beret ... today ... and soon you'll be making hay!",
      49.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "BlackBasqueBeret.jpg",
      "BlackBasqueBeret.thumb.jpg",
      0,
      mutableSetOf(cat4)
    )
    val prod24 = Product(
      "Cotton Beret",
      "The Parkhurst SunGuard line of headwear offers the comfort and breathability of cotton and provides up to 50 times your natural protection from the sun's rays. Fashionable, durable, and washable, Sunguard is the only choice.",
      12.95.toBigDecimal(),
      7.95.toBigDecimal(),
      "CottonBeret.jpg",
      "CottonBeret.thumb.jpg",
      2,
      mutableSetOf(cat4)
    )
    val prod25 = Product(
      "Wool Beret",
      "This classic tam from Kangol is one size fits all. It's composed of 100% wool and measures 11\" in diameter.",
      24.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "WoolBeret.jpg",
      "WoolBeret.thumb.jpg",
      0,
      mutableSetOf(cat4)
    )
    val prod26 = Product(
      "Military Beret",
      "As one of our best selling berets, this Black Military Beret is especially popular in these war-torn days. Made of wool felt, it's a facsimile of what Monty wore in the deserts of Africa in World War II. We don't guarantee any sweeping victories with this beret, but you might score a personal triumph or two!",
      19.99.toBigDecimal(),
      12.95.toBigDecimal(),
      "MilitaryBeret.jpg",
      "MilitaryBeret.thumb.jpg",
      3,
      mutableSetOf(cat4, cat7)
    )
    val prod27 = Product(
      "Bond-Leather Driver",
      "Leather was never so stylish. The Bond-Driver has an elastic sweatband for a sure fit. Seamed and unlined, this driver is perfect for cruising around town or saving the world.",
      49.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "Bond-LeatherDriver.jpg",
      "Bond-LeatherDriver.thumb.jpg",
      0,
      mutableSetOf(cat5)
    )
    val prod28 = Product(
      "Moleskin Driver",
      "This quality ivy cap made by Christy's comes with a finished lining. The material of this ivy is called moleskin and is very soft. If your life's kinda in a hole ... and you wish you had a little more soul ... no need to beat your head against a pole, Ken ... just purchase our Christy's Ivy Cap in Moleskin!",
      29.99.toBigDecimal(),
      25.00.toBigDecimal(),
      "MoleskinDriver.jpg",
      "MoleskinDriver.thumb.jpg",
      2,
      mutableSetOf(cat5)
    )
    val prod29 = Product(
      "Herringbone English Driver",
      "Herringbone is everywhere this year from head to toe. The English Driver ivy cap is made of wool with a cotton sweatband on the inside.",
      29.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "HerringboneEnglishDriver.jpg",
      "HerringboneEnglishDriver.thumb.jpg",
      0,
      mutableSetOf(cat5)
    )
    val prod30 = Product(
      "Confederate Civil War Kepi",
      "Rebel Hat - Southern Hat - This kepi comes with the crossed musket emblem on the front.",
      14.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ConfederateCivilWarKepi.jpg",
      "ConfederateCivilWarKepi.thumb.jpg",
      0,
      mutableSetOf(cat6)
    )
    val prod31 = Product(
      "Hillbilly Hat",
      "Blocked wool, with a rope band. Please allow 1-2 weeks for delivery. Some sizes available for immediate shipment. Corn Cob pipe not included! So, go ahead Joe, or Carl, or Billy ... act nutso and be silly ... because we've got you covered willy-nilly ... in our sleepy-hollow Hillbilly!",
      139.99.toBigDecimal(),
      124.95.toBigDecimal(),
      "HillbillyHat.jpg",
      "HillbillyHat.thumb.jpg",
      2,
      mutableSetOf(cat6)
    )
    val prod32 = Product(
      "Mother Goose Hat",
      "Sorceress Witch Hat - Boil, Boil, Toil and Trouble! Mix up a pot of your best witch's brew in this blocked wool felt hat. Available in almost all color combinations - email us for more information.",
      149.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "MotherGooseHat.jpg",
      "MotherGooseHat.thumb.jpg",
      0,
      mutableSetOf(cat6)
    )
    val prod33 = Product(
      "Uncle Sam Top Hat",
      "Patriotic Hats, Uncle Sam Top Hat - This silk topper is a show stopper. Hand-fashioned quality will transform you into a Yankee Doodle Dandy ... Or you can call us a macaroni (something like that).",
      199.00.toBigDecimal(),
      175.00.toBigDecimal(),
      "UncleSamTopHat.jpg",
      "UncleSamTopHat.thumb.jpg",
      2,
      mutableSetOf(cat6)
    )
    val prod34 = Product(
      "Velvet Sombrero Hat",
      "Ay Caramba! This is the real thing! Get into this velvet sombrero, which is richly embossed with sequins. Comes in red and black.",
      79.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "VelvetSombreroHat.jpg",
      "VelvetSombreroHat.thumb.jpg",
      0,
      mutableSetOf(cat6)
    )
    val prod35 = Product(
      "Conductor Hat",
      "Train Railroad Conductor Hat - You been working on the railroad all the live-long day? Well now, you can wear our Conductor's hat, and your troubles will all go away! We sell a ton of these! Set the scene correctly with an authentic train or streetcar conductor's uniform hat. Also makes a great gift for transportation enthusiasts. Don't be a drain ... get on the train!",
      69.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "ConductorHat.jpg",
      "ConductorHat.thumb.jpg",
      0,
      mutableSetOf(cat6)
    )
    val prod36 = Product(
      "Traditional Colonial Tricorn Hat",
      "Truly revolutionary headgear. This hat is blocked from black wool, and edges are finished with white ribbon. The edges are tacked up for durability. So if you're glad to be born ... if you wanna toot your own horn ... just hop out of bed some lovely morn ... and put on our Traditional Colonial Tricorn!",
      39.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "TraditionalColonialTricornHat.jpg",
      "TraditionalColonialTricornHat.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    val prod37 = Product(
      "Metal Viking Helmet",
      "You can almost hear the creaking oars of your warship as you glide across open seas! Conquer worlds with this authentic Nordic reproduction. Crafted from metal and horn, the Viking helmet is a necessity for any adventure. Would you adorn it while biking? ... How about on the wooded trials while hiking? ... Betcha it'll always be to your liking ... wherever you wear our Metal Viking!",
      119.99.toBigDecimal(),
      105.95.toBigDecimal(),
      "MetalVikingHelmet.jpg",
      "MetalVikingHelmet.thumb.jpg",
      2,
      mutableSetOf(cat7)
    )
    val prod38 = Product(
      "Confederate Slouch Hat",
      "Our replica Confederate Slouch Hat from the Civil War comes with Cavalry yellow straps and crossed-sword emblem.",
      129.99.toBigDecimal(),
      101.99.toBigDecimal(),
      "ConfederateSlouchHat.jpg",
      "ConfederateSlouchHat.thumb.jpg",
      1,
      mutableSetOf(cat7)
    )
    val prod39 = Product(
      "Campaign Hat",
      "Dress the part of Dudley-Do-Right, State Trooper Bob, Smokey the Bear, or WWI Doughboy. Wear it in the rain ... wear it carrying a cane ... wear it if you're crazy or sane ... just wear our versatile Campaign!",
      44.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "CampaignHat.jpg",
      "CampaignHat.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    val prod40 = Product(
      "Civil War Union Slouch Hat",
      "This Yankee slouch hat from the Civil War era comes in a black wool felt material and has the U.S. metal emblem on the front. This Union hat comes with the officer's cords.",
      129.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "CivilWarUnionSlouchHat.jpg",
      "CivilWarUnionSlouchHat.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    val prod41 = Product(
      "Civil War Leather Kepi Cap",
      "Calling all Civil War buffs! Yanks grab the blue, and Rebs get the gray. You'll all be victorious in this suede cap worn in the \"War Between the States.\" So, if on the Civil War you're hep-eee ... then by all means, you gotta have our kepi!",
      39.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "CivilWarLeatherKepiCap.jpg",
      "CivilWarLeatherKepiCap.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    val prod42 = Product(
      "Cavalier Hat - Three Musketeers",
      "Reproduction of the original Cavalier hat complete with a feather! Handblocked from 100% wool felt. This is as close to the real thing as you get. It is better than downing a beer ... it is better than having your honey say, \"Come on over here, Dear\" ... All you gotta do is let go of your fear ... and order this stunning, galant Cavalier!",
      185.00.toBigDecimal(),
      0.00.toBigDecimal(),
      "CavalierHat-ThreeMusketeers.jpg",
      "CavalierHat-ThreeMusketeers.thumb.jpg",
      1,
      mutableSetOf(cat7)
    )
    val prod43 = Product(
      "Hussar Military Hat",
      "A \"Hussar\" was an enlisted Cavalry soldier. All hussar soldiers were taught to read and write, and they commonly kept journals of some sort - probably helping them to pass the time while they were away from home in the service of their country. They were required to keep records of their duties and work, as well.",
      199.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "HussarMilitaryHat.jpg",
      "HussarMilitaryHat.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    val prod44 = Product(
      "Union Civil War Kepi Cap",
      "Union Soldier's Cap - Yankee Cap - This kepi comes with the crossed musket emblem on the front.",
      14.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "UnionCivilWarKepiCap.jpg",
      "UnionCivilWarKepiCap.thumb.jpg",
      2,
      mutableSetOf(cat7)
    )
    val prod45 = Product(
      "Tarbucket Helmet Military Hat",
      "This is a reproduction Tarbucket type hat. This style was a popular military style in the early to mid 1800s. The style is similar to a shako hat, with the main difference being that the crown flairs outward.",
      299.99.toBigDecimal(),
      0.00.toBigDecimal(),
      "TarbucketHelmetMilitaryHat.jpg",
      "TarbucketHelmetMilitaryHat.thumb.jpg",
      0,
      mutableSetOf(cat7)
    )
    productRepository.saveAll(
      listOf(
        prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10,
        prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20,
        prod21, prod22, prod23, prod24, prod25, prod26, prod27, prod28, prod29, prod30,
        prod31, prod32, prod33, prod34, prod35, prod36, prod37, prod38, prod39, prod40,
        prod41, prod42, prod43, prod44, prod45
      )
    )

    val shipR1 = ShippingRegion("Please Select")
    val shipR2 = ShippingRegion("US / Canada")
    val shipR3 = ShippingRegion("Europe")
    val shipR4 = ShippingRegion("Rest of World")
    shippingRegionRepository.saveAll(listOf(shipR1, shipR2, shipR3, shipR4))

    val ship1 = Shipping("Next Day Delivery ($20)", 20.00.toBigDecimal(), shipR2)
    val ship2 = Shipping("3-4 Days ($10)", 10.00.toBigDecimal(), shipR2)
    val ship3 = Shipping("7 Days ($5)", 5.00.toBigDecimal(), shipR2)
    val ship4 = Shipping("By air (7 days, $25)", 25.00.toBigDecimal(), shipR3)
    val ship5 = Shipping("By sea (28 days, $10)", 10.00.toBigDecimal(), shipR3)
    val ship6 = Shipping("By air (10 days, $35)", 35.00.toBigDecimal(), shipR4)
    val ship7 = Shipping("By sea (28 days, $30)", 30.00.toBigDecimal(), shipR4)
    shippingRepository.saveAll(listOf(ship1, ship2, ship3, ship4, ship5, ship6, ship7))

    val tax1 = Tax("Sales Tax at 8.5%", 8.50.toBigDecimal())
    val tax2 = Tax("No Tax", 0.00.toBigDecimal())
    taxRepository.saveAll(listOf(tax1, tax2))

    val customerRole = roleRepository.save(Role("ROLE_CUSTOMER"))
    val adminRole = roleRepository.save(Role("ROLE_ADMIN"))

    customerRepository.save(
      Customer(
        "customer1",
        "customer1",
        "customer1",
        "customer1@email.com",
        encoder.encode("password123"),
        mutableSetOf(customerRole),
        shipR2
      )
    )

    userRepository.save(
      EUser(
        "Admin",
        "One",
        "admin1",
        "admin1@email.com",
        encoder.encode("password123"),
        mutableSetOf(adminRole)
      )
    )
  }
}
