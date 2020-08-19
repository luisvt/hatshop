package com.hatshop.server.utils

import com.hatshop.server.models.*
import com.hatshop.server.repositories.*
import com.hatshop.server.security.models.Role
import com.hatshop.server.security.models.User
import com.hatshop.server.security.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@Profile(['default', 'dev'])
class InitDb implements CommandLineRunner {

    @Autowired
    UserRepository userRepository
    @Autowired
    CustomerRepository customerRepository
    @Autowired
    ShippingRegionRepository shippingRegionRepository
    @Autowired
    DepartmentRepository departmentRepository
    @Autowired
    CategoryRepository categoryRepository
    @Autowired
    ProductRepository productRepository
    @Autowired
    ShippingRepository shippingRepository
    @Autowired
    TaxRepository taxRepository

    @Override
    void run(String... args) throws Exception {

//		def resource = new EncodedResource(new ClassPathResource("_data.sql"))
//		ScriptUtils.executeSqlScript(dataSource.connection, resource, true, true, '--', ';', '/*', '*/')

        def dep1 = new Department('Holiday', 'Prepare for the holidays with our special collection of seasonal hats!'),
            dep2 = new Department('Caps and Berets', 'The perfect hats to wear at work and costume parties!'),
            dep3 = new Department('Costume Hats', 'Find the matching hat for your new costume!')
        departmentRepository.saveAll([dep1, dep2, dep3])

        def cat1 = new Category(dep1, 'Christmas Hats', 'Enjoy browsing our collection of Christmas hats!'),
            cat2 = new Category(dep1, 'Halloween Hats', 'Find the hat you\'ll wear this Halloween!'),
            cat3 = new Category(dep1, 'St. Patrick\'s Day Hats', 'Try one of these beautiful hats on St. Patrick\'s Day!'),
            cat4 = new Category(dep2, 'Berets', 'An amazing collection of berets from all around the world!'),
            cat5 = new Category(dep2, 'Driving Caps', 'Be an original driver! Buy a driver\'s hat today!'),
            cat6 = new Category(dep3, 'Theatrical Hats', 'Going to a costume party? Try one of these hats to complete your costume!'),
            cat7 = new Category(dep3, 'Military Hats', 'This collection contains the most realistic replicas of military hats!')
        categoryRepository.saveAll([cat1, cat2, cat3, cat4, cat5, cat6, cat7])

        def prod1 = new Product('Christmas Candy Hat', 'Be everyone\'s "sweetie" while wearing this fun and festive peppermint candy hat. The Christmas Candy hat, made by Elope, stands about 15 inches tall and has a sizing adjustment on the inside.', 24.99, 0.00, 'ChristmasCandyHat.jpg', 'ChristmasCandyHat.thumb.jpg', (short) 0, [cat1] as Set),
            prod2 = new Product('Hanukah Hat', 'The Hanukah hat is a fun and festive way for you to enjoy yourself during the holiday. Made by Elope and adorned with 9 candles, this menorah is sure to brighten the winter celebration.', 24.99, 21.99, 'HanukahHat.jpg', 'HanukahHat.thumb.jpg', (short) 2, [cat1] as Set),
            prod3 = new Product('Springy Santa Hat', 'Santa Hat - Boing-Boing-Boing. Santa will be springing into town with this outrageous cap! If your children are whiney and clingy ... and your head\'s going ping-pong-pingy ... and you feel like just rowing away in your rubber dinghy ... Take heart! You\'ll bounce bounce back ... if you just put on our Santa hat that\'s Springy!', 19.99, 0.00, 'SpringySantaHat.jpg', 'SpringySantaHat.thumb.jpg', (short) 0, [cat1] as Set),
            prod4 = new Product('Plush Santa Hat', 'Get into the spirit of the season with this plush, velvet-like, Santa hat. Comes in a beautiful crimson red color with a faux-fur trim.', 12.99, 0.00, 'PlushSantaHat.jpg', 'PlushSantaHat.thumb.jpg', (short) 0, [cat1] as Set),
            prod5 = new Product('Red Santa Cowboy Hat', 'This velvet Cowboy Santa Hat is one size fits all and has white faux-fur trim all around. Here comes Santa Claus ... Here comes Santa Claus ... right down Cowboy Lane!', 24.99, 0.00, 'RedSantaCowboyHat.jpg', 'RedSantaCowboyHat.thumb.jpg', (short) 0, [cat1] as Set),
            prod6 = new Product('Santa Jester Hat', 'This three-prong velvet jester is one size fits all and has an adjustable touch fastener back for perfect fitting.', 24.99, 0.00, 'SantaJesterHat.jpg', 'SantaJesterHat.thumb.jpg', (short) 0, [cat1] as Set),
            prod7 = new Product('Santa\'s Elf Hat', 'Be Santa\'s best looking helper with this velvet hat, complete with attached ears. So, if you don\'t wanna be yourself ... don\'t worry ... this Christmas, just be Santa\'s elf! Happy Holidays!', 24.99, 16.95, 'Santa\'sElfHat.jpg', 'Santa\'sElfHat.thumb.jpg', (short) 1, [cat1] as Set),
            prod8 = new Product('Chauffeur Hat', 'Uniform Chauffeur Cap. This cap is the real thing. Well-made and professional looking, our Chauffeur hat gets so many compliments from our customers who buy (and wear) them. It\'s absolutely amazing how many of these we sell. One thing\'s for sure, this authentic professional cap will let everyone know exactly who\'s in the driver\'s seat. So ... whether you\'re driving Miss Daisy ... or driving yourself crazy ... I\'ll bet your wife will coo and purr ... when she sees you in our authentic chauffer!', 69.99, 0.00, 'ChauffeurHat.jpg', 'ChauffeurHat.thumb.jpg', (short) 0, [cat2, cat5] as Set),
            prod9 = new Product('The Pope Hat', 'We\'re not sure what the Vatican\'s official position is on this hat, but we do know your friends will love you in this soft velour hat with gold lame accents. If you\'re somewhat lacking in religion ... if you\'re looking for some hope ... you might acquire just a smidgeon ... by faithfully wearing our Pope!', 29.99, 0.00, 'ThePopeHat.jpg', 'ThePopeHat.thumb.jpg', (short) 0, [cat2] as Set),
            prod10 = new Product('Vinyl Policeman Cop Hat', 'A hat that channels the 70s. This oversized vinyl cap with silver badge will make you a charter member of the disco era ... or is that disco error?', 29.99, 0.00, 'VinylPolicemanCopHat.jpg', 'VinylPolicemanCopHat.thumb.jpg', (short) 0, [cat2] as Set),
            prod11 = new Product('Burgundy Kings Crown', 'Our burgundy Kings Crown is one size fits all. This crown is adorned with gold ribbon, gems, and a faux-fur headband. Be King for a Day ... Finally get your say ... Put your foot down ... and do it with humor, wearing our Elegant Burgundy King\'s Crown!', 34.99, 25.95, 'BurgandyKingsCrown.jpg', 'BurgandyKingsCrown.thumb.jpg', (short) 2, [cat2] as Set),
            prod12 = new Product('454 Black Pirate Hat', 'Our wool felt Pirate Hat comes with the front and back brims turned upward. This sized hat has the pirate emblem on the front. So, ho, ho, ho and a bottle of rum ... if you\'re about as crazy as they come ... wear our Pirate hat this coming Halloween ... and with an eyepatch to boot, you\'ll be lusty, lean and mean!', 39.99, 0.00, '454BlackPirateHat.jpg', '454BlackPirateHat.thumb.jpg', (short) 0, [cat2] as Set),
            prod13 = new Product('Black Puritan Hat', 'Haentze Hatcrafters has been making quality theatrical and military headgear for decades. Each hat is made meticulously by hand with quality materials. Many of these hats have been used in movies and historical reproductions and re-enactments.', 89.99, 75.99, 'BlackPuritanHat.jpg', 'BlackPuritanHat.thumb.jpg', (short) 2, [cat2] as Set),
            prod14 = new Product('Professor McGonagall Witch Hat', 'Professor McGonagall, Deputy Headmistress of Hogwarts and Head of Gryffindor House, commands respect in this dramatic witch hat - and so will you! The inside of this hat has a touch fastener size-adjustment tab. The hat is a must for all Harry Potter fans!', 24.99, 0.00, 'ProfessorMcGonagallWitchHat.jpg', 'ProfessorMcGonagallWitchHat.thumb.jpg', (short) 0, [cat2] as Set),
            prod15 = new Product('Black Wizard Hat', 'This cool Merlin-style wizard hat by Elope has a dragon that lays around the whole hat. The wizard hat is one size fits all and has a touch fastener on the inside to adjust accordingly.', 34.99, 0.00, 'BlackWizardHat.jpg', 'BlackWizardHat.thumb.jpg', (short) 0, [cat2] as Set),
            prod16 = new Product('Leprechaun Hat', 'Show them the green! This hand-blocked, wool felt hat will make you the hit of this year\'s St. Paddy\'s Day Celebration! Oh yes, the green you will don ... and what better way, hon ... than if this St. Patrick\'s Day ... you\'re wearing our cool Leprechaun!', 88.99, 0.00, 'LeprechaunHat.jpg', 'LeprechaunHat.thumb.jpg', (short) 0, [cat3] as Set),
            prod17 = new Product('9 Green MadHatter Top Hat', 'Each of our MadHatter hats is made meticulously by hand with quality materials. Many of these hats have been used in movies and historical reproductions and re-enactments.', 149.99, 124.95, '9GreenMadHatterTopHat.jpg', '9GreenMadHatterTopHat.thumb.jpg', (short) 2, [cat3] as Set),
            prod18 = new Product('Winter Walking Hat', 'Our declarative English walking hat by Christy\'s of London comes in 100% Lana Wool and reveals a finished satin lining. Christy\'s has been making hats since 1773 and knows how to make the best! Want proof? Try this one ... Irish eyes will be smiling.', 49.99, 0.00, 'WinterWalkingHat.jpg', 'WinterWalkingHat.thumb.jpg', (short) 0, [cat3] as Set),
            prod19 = new Product('Green MadHatter Hat', 'St. Patrick\'s Day Hat - Luck o\' the Irish! This oversized green velveteen MadHatter is great for St.Patrick\'s day or a MadHatter\'s tea party.One size fits most adults.', 39.99, 28.99, 'GreenMadHatterHat.jpg', 'GreenMadHatterHat.thumb.jpg', (short) 2, [cat3] as Set),
            prod20 = new Product('Hole in One Golf Costume Hat', 'Golf Hat - OK, Ace. This spoof golfer\'s hat sports an astro-turf "green," has an attached golf ball and flag, and includes a soft elastic band  for comfort. This hat also makes a great gift that is definitely "up to par" for any goofball\'s - uh - golfballer\'s taste. Perfect for Dad! And don\'t you fore-get-it!', 29.99, 0.00, 'HoleinOneGolfCostumeHat.jpg', 'HoleinOneGolfCostumeHat.thumb.jpg', (short) 0, [cat3] as Set),
            prod21 = new Product('Luck of the Irish Bowler', 'This one size fits all Irish Derby comes with a shamrock attached to the side. This hat is made of a soft velvet and is comfortably sized.', 29.99, 0.00, 'LuckoftheIrishBowler.jpg', 'LuckoftheIrishBowler.thumb.jpg', (short) 0, [cat3] as Set),
            prod22 = new Product('St. Patrick\'s Irish Green Derby', 'This quality bowler will last you more than one St. Patrick\'s Day! A proper derby for the day, it is made of wool felt and has a green grosgrain band. This hat is not lined.', 39.99, 0.00, 'St.Patrick\'sIrishGreenDerby.jpg', 'St.Patrick\'sIrishGreenDerby.thumb.jpg', (short) 0, [cat3] as Set),
            prod23 = new Product('Black Basque Beret', 'This is our tried and true men\'s classic beret hat(tam). Our Basque beret is superbly crafted, 100% wool, and has a comfortable leather sweatband. Lined and water resistant, the beret is great for everyday wear and rolls up nicely to fit in your pocket. So ... if you\'re antsy ... in your pantsy ... cause you wanna catch the fancy ... of the lady near your way ... then please don\'t delay ... just get this beret ... today ... and soon you\'ll be making hay!', 49.99, 0.00, 'BlackBasqueBeret.jpg', 'BlackBasqueBeret.thumb.jpg', (short) 0, [cat4] as Set),
            prod24 = new Product('Cotton Beret', 'The Parkhurst SunGuard line of headwear offers the comfort and breathability of cotton and provides up to 50 times your natural protection from the sun\'s rays. Fashionable, durable, and washable, Sunguard is the only choice.', 12.95, 7.95, 'CottonBeret.jpg', 'CottonBeret.thumb.jpg', (short) 2, [cat4] as Set),
            prod25 = new Product('Wool Beret', 'This classic tam from Kangol is one size fits all. It\'s composed of 100% wool and measures 11" in diameter.', 24.99, 0.00, 'WoolBeret.jpg', 'WoolBeret.thumb.jpg', (short) 0, [cat4] as Set),
            prod26 = new Product('Military Beret', 'As one of our best selling berets, this Black Military Beret is especially popular in these war-torn days. Made of wool felt, it\'s a facsimile of what Monty wore in the deserts of Africa in World War II. We don\'t guarantee any sweeping victories with this beret, but you might score a personal triumph or two!', 19.99, 12.95, 'MilitaryBeret.jpg', 'MilitaryBeret.thumb.jpg', (short) 3, [cat4, cat7] as Set),
            prod27 = new Product('Bond-Leather Driver', 'Leather was never so stylish. The Bond-Driver has an elastic sweatband for a sure fit. Seamed and unlined, this driver is perfect for cruising around town or saving the world.', 49.99, 0.00, 'Bond-LeatherDriver.jpg', 'Bond-LeatherDriver.thumb.jpg', (short) 0, [cat5] as Set),
            prod28 = new Product('Moleskin Driver', 'This quality ivy cap made by Christy\'s comes with a finished lining. The material of this ivy is called moleskin and is very soft. If your life\'s kinda in a hole ... and you wish you had a little more soul ... no need to beat your head against a pole, Ken ... just purchase our Christy\'s Ivy Cap in Moleskin!', 29.99, 25.00, 'MoleskinDriver.jpg', 'MoleskinDriver.thumb.jpg', (short) 2, [cat5] as Set),
            prod29 = new Product('Herringbone English Driver', 'Herringbone is everywhere this year from head to toe. The English Driver ivy cap is made of wool with a cotton sweatband on the inside.', 29.99, 0.00, 'HerringboneEnglishDriver.jpg', 'HerringboneEnglishDriver.thumb.jpg', (short) 0, [cat5] as Set),
            prod30 = new Product('Confederate Civil War Kepi', 'Rebel Hat - Southern Hat - This kepi comes with the crossed musket emblem on the front.', 14.99, 0.00, 'ConfederateCivilWarKepi.jpg', 'ConfederateCivilWarKepi.thumb.jpg', (short) 0, [cat6] as Set),
            prod31 = new Product('Hillbilly Hat', 'Blocked wool, with a rope band. Please allow 1-2 weeks for delivery. Some sizes available for immediate shipment. Corn Cob pipe not included! So, go ahead Joe, or Carl, or Billy ... act nutso and be silly ... because we\'ve got you covered willy-nilly ... in our sleepy-hollow Hillbilly!', 139.99, 124.95, 'HillbillyHat.jpg', 'HillbillyHat.thumb.jpg', (short) 2, [cat6] as Set),
            prod32 = new Product('Mother Goose Hat', 'Sorceress Witch Hat - Boil, Boil, Toil and Trouble! Mix up a pot of your best witch\'s brew in this blocked wool felt hat. Available in almost all color combinations - email us for more information.', 149.99, 0.00, 'MotherGooseHat.jpg', 'MotherGooseHat.thumb.jpg', (short) 0, [cat6] as Set),
            prod33 = new Product('Uncle Sam Top Hat', 'Patriotic Hats, Uncle Sam Top Hat - This silk topper is a show stopper. Hand-fashioned quality will transform you into a Yankee Doodle Dandy ... Or you can call us a macaroni (something like that).', 199.00, 175.00, 'UncleSamTopHat.jpg', 'UncleSamTopHat.thumb.jpg', (short) 2, [cat6] as Set),
            prod34 = new Product('Velvet Sombrero Hat', 'Ay Caramba! This is the real thing! Get into this velvet sombrero, which is richly embossed with sequins. Comes in red and black.', 79.99, 0.00, 'VelvetSombreroHat.jpg', 'VelvetSombreroHat.thumb.jpg', (short) 0, [cat6] as Set),
            prod35 = new Product('Conductor Hat', 'Train Railroad Conductor Hat - You been working on the railroad all the live-long day? Well now, you can wear our Conductor\'s hat, and your troubles will all go away! We sell a ton of these! Set the scene correctly with an authentic train or streetcar conductor\'s uniform hat. Also makes a great gift for transportation enthusiasts. Don\'t be a drain ... get on the train!', 69.99, 0.00, 'ConductorHat.jpg', 'ConductorHat.thumb.jpg', (short) 0, [cat6] as Set),
            prod36 = new Product('Traditional Colonial Tricorn Hat', 'Truly revolutionary headgear. This hat is blocked from black wool, and edges are finished with white ribbon. The edges are tacked up for durability. So if you\'re glad to be born ... if you wanna toot your own horn ... just hop out of bed some lovely morn ... and put on our Traditional Colonial Tricorn!', 39.99, 0.00, 'TraditionalColonialTricornHat.jpg', 'TraditionalColonialTricornHat.thumb.jpg', (short) 0, [cat7] as Set),
            prod37 = new Product('Metal Viking Helmet', 'You can almost hear the creaking oars of your warship as you glide across open seas! Conquer new worlds with this authentic Nordic reproduction. Crafted from metal and horn, the Viking helmet is a necessity for any adventure. Would you adorn it while biking? ... How about on the wooded trials while hiking? ... Betcha it\'ll always be to your liking ... wherever you wear our Metal Viking!', 119.99, 105.95, 'MetalVikingHelmet.jpg', 'MetalVikingHelmet.thumb.jpg', (short) 2, [cat7] as Set),
            prod38 = new Product('Confederate Slouch Hat', 'Our replica Confederate Slouch Hat from the Civil War comes with Cavalry yellow straps and crossed-sword emblem.', 129.99, 101.99, 'ConfederateSlouchHat.jpg', 'ConfederateSlouchHat.thumb.jpg', (short) 1, [cat7] as Set),
            prod39 = new Product('Campaign Hat', 'Dress the part of Dudley-Do-Right, State Trooper Bob, Smokey the Bear, or WWI Doughboy. Wear it in the rain ... wear it carrying a cane ... wear it if you\'re crazy or sane ... just wear our versatile Campaign!', 44.99, 0.00, 'CampaignHat.jpg', 'CampaignHat.thumb.jpg', (short) 0, [cat7] as Set),
            prod40 = new Product('Civil War Union Slouch Hat', 'This Yankee slouch hat from the Civil War era comes in a black wool felt material and has the U.S. metal emblem on the front. This Union hat comes with the officer\'s cords.', 129.99, 0.00, 'CivilWarUnionSlouchHat.jpg', 'CivilWarUnionSlouchHat.thumb.jpg', (short) 0, [cat7] as Set),
            prod41 = new Product('Civil War Leather Kepi Cap', 'Calling all Civil War buffs! Yanks grab the blue, and Rebs get the gray. You\'ll all be victorious in this suede cap worn in the "War Between the States." So, if on the Civil War you\'re hep-eee ... then by all means, you gotta have our kepi!', 39.99, 0.00, 'CivilWarLeatherKepiCap.jpg', 'CivilWarLeatherKepiCap.thumb.jpg', (short) 0, [cat7] as Set),
            prod42 = new Product('Cavalier Hat - Three Musketeers', 'Reproduction of the original Cavalier hat complete with a feather! Handblocked from 100% wool felt. This is as close to the real thing as you get. It is better than downing a beer ... it is better than having your honey say, "Come on over here, Dear" ... All you gotta do is let go of your fear ... and order this stunning, galant Cavalier!', 185.00, 0.00, 'CavalierHat-ThreeMusketeers.jpg', 'CavalierHat-ThreeMusketeers.thumb.jpg', (short) 1, [cat7] as Set),
            prod43 = new Product('Hussar Military Hat', 'A "Hussar" was an enlisted Cavalry soldier. All hussar soldiers were taught to read and write, and they commonly kept journals of some sort - probably helping them to pass the time while they were away from home in the service of their country. They were required to keep records of their duties and work, as well.', 199.99, 0.00, 'HussarMilitaryHat.jpg', 'HussarMilitaryHat.thumb.jpg', (short) 0, [cat7] as Set),
            prod44 = new Product('Union Civil War Kepi Cap', 'Union Soldier\'s Cap - Yankee Cap - This kepi comes with the crossed musket emblem on the front.', 14.99, 0.00, 'UnionCivilWarKepiCap.jpg', 'UnionCivilWarKepiCap.thumb.jpg', (short) 2, [cat7] as Set),
            prod45 = new Product('Tarbucket Helmet Military Hat', 'This is a reproduction Tarbucket type hat. This style was a popular military style in the early to mid 1800s. The style is similar to a shako hat, with the main difference being that the crown flairs outward.', 299.99, 0.00, 'TarbucketHelmetMilitaryHat.jpg', 'TarbucketHelmetMilitaryHat.thumb.jpg', (short) 0, [cat7] as Set)
        productRepository.saveAll([
                prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10,
                prod11, prod12, prod13, prod14, prod15, prod16, prod17, prod18, prod19, prod20,
                prod21, prod22, prod23, prod24, prod25, prod26, prod27, prod28, prod29, prod30,
                prod31, prod32, prod33, prod34, prod35, prod36, prod37, prod38, prod39, prod40,
                prod41, prod42, prod43, prod44, prod45
        ])

        def shipR1 = new ShippingRegion('Please Select'),
            shipR2 = new ShippingRegion('US / Canada'),
            shipR3 = new ShippingRegion('Europe'),
            shipR4 = new ShippingRegion('Rest of World')
        shippingRegionRepository.saveAll([shipR1, shipR2, shipR3, shipR4])

        def ship1 = new Shipping('Next Day Delivery ($20)', 20.00, shipR2),
            ship2 = new Shipping('3-4 Days ($10)', 10.00, shipR2),
            ship3 = new Shipping('7 Days ($5)', 5.00, shipR2),
            ship4 = new Shipping('By air (7 days, $25)', 25.00, shipR3),
            ship5 = new Shipping('By sea (28 days, $10)', 10.00, shipR3),
            ship6 = new Shipping('By air (10 days, $35)', 35.00, shipR4),
            ship7 = new Shipping('By sea (28 days, $30)', 30.00, shipR4)
        shippingRepository.saveAll([ship1, ship2, ship3, ship4, ship5, ship6, ship7])

        def tax1 = new Tax('Sales Tax at 8.5%', 8.50),
        tax2 = new Tax('No Tax', 0.00)
        taxRepository.saveAll([tax1, tax2])

        def roleUser = new Role("ROLE_USER"),
            encoder = new BCryptPasswordEncoder()

        customerRepository.saveAll([
                new Customer(
                        firstName: 'customer1',
                        lastName: 'customer1',
                        username: 'customer1',
                        password: encoder.encode("password123"),
                        email: 'customer1@email.com',
                        shippingRegion: shipR2,
                        authorities: [roleUser]
                )
        ])

        def admin1 = new User('Admin', 'One', 'admin1', 'admin1@email.com', encoder.encode('password123'), [new Role('ROLE_ADMIN')])
        userRepository.save(admin1)
    }
}
