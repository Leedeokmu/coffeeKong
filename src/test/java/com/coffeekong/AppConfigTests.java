package com.coffeekong;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppConfigTests {

	StringBuilder sb = new StringBuilder();

	@Before
	public void init(){
		sb.append("insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'SingleOrigins', 'Bolivia', 'A clean, sweet, and flavorful coffee that is the result of meticulous artisanal techniques in all levels of production. Our Bolivian coffee is smooth, creamy, and delicious, with notes of chocolate and roasted almond. The light-to-medium roast allows for the soft citrus acidity to shine, striking the perfect balance with the rich and mellow medium body. The processing plant in El Alto used by our farming partners still sorts out defects by hand, a lengthy process which ensures that withered, immature, and insect-damaged beans never make their way into your cup. The result is a coffee which is luscious from beginning to end, all the way through its caramel-like finish.\n" +
				"', 15.99, sysdate, '/resources/dist/product/bolivia-SingleOrigins.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'SingleOrigins', 'HONDURAS KEDVIN MORENO', 'The Honduras Kedvin Moreno was carefully roasted for you by Tandem Coffee Roasters. This fully washed coffee was grown by the Kedvin Moreno in the Santa Barbara region of Honduras between 1,510 - 1,550 meters above sea level. \n" +
				"We love this coffee for its nuanced notes of spiced pear, chocolate, and floral aroma.', 12.99, sysdate, '/resources/dist/product/HONDURAS_KEDVIN_MORENO-SingleOrigins.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'SingleOrigins', 'guatemala', 'Clean, sweet, with a classic Central American profile that pairs extremely well with dessert. The notes of cocoa and brown sugar give way to a hint of caramelized apples in the finish. Grown on small family farms high in the Sierra Madre mountain range of Honduras, we have the farmers of the Coprocael cooperative to thank for these beans.\n" +
				"', 13.99, sysdate, '/resources/dist/product/guatemala-SingleOrigins.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Blends', 'NATURAL HIGH', 'This is the Natural High brought to you by Kaldi''s Coffee Roasting Co. A South and Central American blend of certified Organic and Fair Trade coffees, roasted until most of their essential oils rise to the surface. A classic roast perennially favored in Continental Europe. This cup is fantastically rich, with notes of roasted nuts and caramel.\n" +
				"', 14.99, sysdate, '/resources/dist/product/NATURAL_HIGH-Blends.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Blends', 'bean martin', 'This is a coffee that we like to show people who think that light roasted single-origins are the only way to go if you''re looking for quality. The flavors in this cup could not exist together were it not for blending, nor could they exist without the deep caramelization of sugars that occurs as a coffee in the roaster approaches second crack. The rich earthiness of Sumatra melds with the sweet bright berry notes of unwashed Ethiopia, taken to a full and robust roast that''s dark without being burnt. A dark roasted Bolivia is blended to unite it all with a rich, creamy body and a hint of chocolate that weaves throughout, resolving in a long and lingering sugary aftertaste. It''s rich, it''s unique, it''s complex.\n" +
				"', 15.99, sysdate, '/resources/dist/product/bean_martin-Blends.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Blends', 'BLEU ORGANIC', 'This is the Bleu Organic brought to you by La Colombe. This dark filter blend coffee continues our commitment to sourcing coffee from farms that emphasize sustainable practices. Bleu is a seasonal dark roast created with organic USDA coffees from Honduras, Nicaragua, and Peru. With cupping notes of milk chocolate and maraschino cherry, this organic blend is a decadence you can feel good about.\n" +
				"', 18.99, sysdate, '/resources/dist/product/BLEU_ORGANIC-Blends.jpg');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Decafs', 'ORGANIC DECAF HONDURAS', 'The Organic Decaf Honduras was roasted for you by Kickapoo Coffee Roasters. This decaf coffee is a single origin coffee from Honduras and was decaffeinated using the natural Mountain Water decaffeination method. This cup is rich and full bodied with notes of caramel and chocolate, and is sure to be a crowdpleaser.\n" +
				"', 18.99, sysdate, '/resources/dist/product/ORGANIC_DECAF_HONDURAS-Decafs.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Decafs', 'Decafs Mexico', 'Nutty, smooth, and medium-bodied. Mellow and sweet with a clean and crisp finish. Water processed decaf means no chemical agent came into contact with your coffee while decaffeinating it. A bright, tangy acidity is softly balanced with its rich body. Hints of brown sugar and cocoa round out the flavor profile, which resolves into a comforting, smooth finish. Our roast profile is not too light, so we pick up on the nice chocolaty notes, but not too dark, so we maintain the acidity. A steady pace during the roast is key to developing the sugars that make this coffee shine.\n" +
				"', 14.99, sysdate, '/resources/dist/product/decaf_mexico-Decafs.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Decafs', 'Half Caf Blend', 'Aromatic, smooth, perfectly balanced. 50% decaf and 50% caffeinated blend. These two worlds collided and made a star!\n" +
				"', 15.49, sysdate, '/resources/dist/product/half_caf_blend-Decafs.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Light', 'KENYA KIBUGU', 'This is the Kenya Kibugu brought to you by Quills Coffee. Grown by the various small holder producers in the Embu region at 1,800 meters, this fully washed coffee is a perfect example of why we love coffees from Kenya. We love this coffee for its classic Kenyan cup profile of blackberry and grapefruit.\n" +
				"', 21.99, sysdate, '/resources/dist/product/KENYA_KIBUGU-Light.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Light', 'WEST END BLUES BLEND', 'The West End Blues Blend was blended and roasted for you by Tandem Coffee Roasters. This combination of coffees create a unique harmony of flavors that are greater than the sum of its parts. This versatile coffee is perfect on its own and lusciously decadent with a bit of cream or steamed milk.\n" +
				"', 18.99, sysdate, '/resources/dist/product/WEST_END_BLUES_BLEND-Light.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Light', 'Sumatra', 'Sumatran coffee has flavors that some find intense and huge on the palate. Those who love this coffee REALLY love this coffee. One of our most unique and most popular single origin offerings, this coffee is characterized by its striking earthy flavor and its rich, musky tones. A mellow acidity is accompanied by a full body swirling with complex sweetness. Our roast is just dark enough to bring out the deep caramel notes that intertwine with the slightly funky flavors that result from the coffee cherries wet hulling process. The finish is long and exquisitely sweet, an intriguing contrast with the rustic characteristics prevalent at the start of the cup.\n" +
				"', 14.59, sysdate, '/resources/dist/product/sumatra-Light.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Medium', 'Cowboy Blend', 'Our most popular blend is a bold and rich mix of Indonesian and American coffees. Sumatra brings a rustic earthiness to the cup, which is balanced beautifully with the buttery smoothness of coffee from Nicaragua. Roasted to a level of darkness which brings out a full-bodied sweetness, but not so dark as to obscure the complex combination of flavors in the cup spicy, roasty, and smoky. The secret to this blend is in its slightly unconventional roasting style, which pulls out many tricks from the book of thermodynamics, heat transfer, and airflow in the roasting drum. What makes Cowboy Blend so eminently drinkable is its effortless ability to be both brusque and smooth. If it were a person, you''d call them ruggedly handsome.\n" +
				"', 13.99, sysdate, '/resources/dist/product/cowboy-Medium.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Medium', 'Dr Mojo', 'This one might be the coffee that is tasted by the most people around us in the Triangle area of North Carolina. Developed to keep the patients and staff at hospitals going 24 hours a day, this blend is smooth and sweet, with a rich creamy body and an inviting mellow acidity. Our medium roast helps the blend components to merge their caramelized sugars into a delicious brew that is both comforting and invigorating.\n" +
				"', 13.99, sysdate, '/resources/dist/product/dr-mojo-Medium.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Medium', 'BON VIVANT', 'This is the Bon Vivant brought to you by Metric Coffee Co. Creating a blend to achieve a particular flavor profile can be very exciting. It allows us to cup samples from all over, with the goal of finding the perfect coffee, or coffees, to suit their needs. In doing so for Bon Vivant, Metric seeks heirloom variety coffees that find harmony and balance within each layer of this blend. The result is a complex cup with notes of baked apple and citrus.\n" +
				"', 18.99, sysdate, '/resources/dist/product/BON_VIVANT-Medium.jpg');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Dark', 'NIZZA ESPRESSO BLEND', 'The Nizza Espresso Blend was carefully roasted for you by La Colombe. Nizza is primarily built as an espresso blend, and works well with all brew methods. This cup is fantastically rich, with notes of caramel and nutty.\n" +
				"', 19.49, sysdate, '/resources/dist/product/NIZZA_ESPRESSO_BLEND-Dark.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Dark', 'Fire in the Belly', 'Xavier Rudd and his posse drink this coffee day & night while on the road. It''s earthy, intense, and smooth. Rich and big with hints of caramel. AND 10% of sales are donated to OXFAM to fight poverty and injustice (their mission is something Xavier cares a lot about, as do we.)\n" +
				"', 14.99, sysdate, '/resources/dist/product/fire_in_the_belly-Dark.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Dark', 'Frenchy French Roast', 'Some places seem to use their French roasts as an opportunity to hide or obscure a lower quality coffee by roasting it so dark they remove all characteristics of origin, leaving only a cup that tastes of carbon and ash. We don''t see the point in that, so our Frenchy French Roast is a carefully selected coffee, usually from South America, that can withstand the high temperatures of the roast profile which takes it to that nice dark level. We take a slow and steady approach to the roast, allowing the beans natural sugars to caramelize nicely without burning. The result is BOLD, DARK, and RICH with a bittersweet chocolate undercurrent. Roasty and piquant with a warm, inviting aftertaste.\n" +
				"', 13.49, sysdate, '/resources/dist/product/frenchy_french_roast-Dark.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'grinder', 'BARATZA ENCORE BURR GRINDER', 'The Encore has 40 individual grind settings, from fine to coarse, and has the ability to please any palate with its gamut of accurate and repeatable grind settings. The Encore has an accurate medium to coarse grind for the increasingly popular manual brew methods such as pour-over, Aeropress, French Press and Chemex.\n" +
				"', 130.00, sysdate, '/resources/dist/product/BARATZA_ENCORE_BURR_GRINDER-grinder.jpg');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'grinder', 'Lido 3 Hand Grinder', 'This Manual Coffee Grinder is built to last and is a personal favorite of Larry''s!</br> Fresh ground coffee anywhere, for any brewing method and a consistent grind every time. The Lido3 is a fantastic travel grinder!</br> \n" +
				"Gritty Details: </br>Swiss made steel conical grinding burr set, it comes with an anti-static brush, a ball driver tool, and a neoprene travel case!', 35.99, sysdate, '/resources/dist/product/lido3_hand_grinder-grinder.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'grinder', 'Hario Skerton Hand Grinder', 'This Ceramic Coffee Mill is easy to use and easy to clean! It''s perfect for traveling, camping, or when the power goes out.\n" +
				"</br>Gritty Details</br>Features conical ceramic burrs, an anti-slip rubber base for easier grinding, the grind setting is easily adjustable, and it''s even dishwasher safe. ', 49.99, sysdate, '/resources/dist/product/hario_skerton_hand_grinder-grinder.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'HomeBrewing', 'Bonmac Ceramic Dripper', 'This classic Single Cup Pour Over Dripper is one of the purest and simplest ways to brew our coffee. It''s all ceramic and it even has a little \"window\" for monitoring your pour. Ready to use right out of the box! \n" +
				"', 13.49, sysdate, '/resources/dist/product/bonmac_ceramic_dripper-HomeBrewing.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'HomeBrewing', 'Hario Drip Brewer and Decanter', 'This sleek Drip Brewer and Decanter is perfect for pour over brewing. When your finished brewing, remove the plastic dripper and you have a decanter to serve your coffee!</br></br>Gritty Details</br>Constructed from heat resistant borosilicate glass, \n" +
				"features a removable silicone band, a removable plastic drip brewer and has a capacity of 25-5/8oz.', 36.49, sysdate, '/resources/dist/product/hario-drip-brewer-and-decanter-HomeBrewing.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'HomeBrewing', 'Hario V60 Drip Scale and Timer', 'This Scale and Timer makes perfecting the your home brewing simple and easy! The scale measures in 0.1 gram increments which make your coffee more consistent than ever before. Not only that, the scale includes a timer to help you perfect every brew.</br></br>\n" +
				"Gritty Details</br>Minimum weight: 2g </br>Maximum weight: 2000g (2kg)', 64.49, sysdate, '/resources/dist/product/hario-v60-drip-scale-and-timer-HomeBrewing.png');\n" +
				"\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Cups', 'Demitasse Cup', 'This 2oz Demitasse Cup has #17 on one side, in honor of our lovely Secret #17 Espresso blend, and our dancing mascot on the other side. This is a must have dinner parties or for your home espresso brewing!\n" +
				"', 4.99, sysdate, '/resources/dist/product/demitasse_cup-Cups.png');\n" +
				"insert into tbl_prod(p_id, p_category, p_name, p_content, p_price, p_mdate, p_img)\n" +
				"values(SEQ_PID.NEXTVAL, 'Cups', 'THE Cowboy Mug', 'This 15oz Cowboy Mug is the mug of choice for many of us here at the bean plant. \n" +
				"We love this mug and we know you will too. ', 7.49, sysdate, '/resources/dist/product/cowboy_mug-Cups.png');\n");

	}
	public static  String escapeXml(String str){
		return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").
				replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;").replaceAll("\\\\", "");
	}
	@Test
	public void contextLoads() {
		System.out.println(escapeXml(sb.toString()));
	}

}
