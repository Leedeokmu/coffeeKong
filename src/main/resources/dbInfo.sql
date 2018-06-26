/*
	DROP USER projectspr;
	CREATE USER projectspr IDENTIFIED BY oracle
	DEFAULT TABLESPACE users
	TEMPORARY TABLESPACE temp;
	
	GRANT CONNECT, RESOURCE TO projectspr;
	
	CONN projectspr/oracle;
*/

-- UPDATE user SET authentication_string=password('test') WHERE user ='root';
set password = password('test');

CREATE USER 'coffeekong'@'%' IDENTIFIED BY 'test';
CREATE USER 'coffeekong'@localhost IDENTIFIED BY 'test';

flush PRIVILEGES;
-- reset password
SET PASSWORD = PASSWORD('test');

GRANT all privileges ON *.* TO 'root'@'%' IDENTIFIED BY 'test' WITH GRANT OPTION;

GRANT all privileges on *.* TO 'coffeekong'@'%' IDENTIFIED BY 'test' WITH GRANT OPTION;
GRANT all privileges on *.* TO 'coffeekong'@localhost IDENTIFIED BY 'test' WITH grant OPTION;

SET GLOBAL max_connections=200;

-- CREATE DATABASE
CREATE DATABASE IF NOT EXISTS `coffeekong`;

use `coffeekong`;
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`(
	`u_email` varchar(200) not null,
	`u_fname` varchar(100) not null,
	`u_lname` varchar(100) not null,
	`u_pwd` varchar(100) not null,
	`u_point` int(10) default 0,
	`sess_id` varchar(50) default 'none',
	`sess_limit` datetime,
	PRIMARY KEY(u_email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tbl_manager;
CREATE TABLE `tbl_manager`(
	m_email varchar(200) not null,
	m_fname varchar(100) not null,
	m_lname varchar(100) not null,
	m_pwd varchar(100) not null,
	sess_id varchar(50) default 'none',
	sess_limit datetime,
	PRIMARY KEY(m_email)
);

DROP TABLE IF EXISTS tbl_prod;
CREATE TABLE `tbl_prod`(
	p_id int(10) not null AUTO_INCREMENT,
	p_category varchar(200) not null,
	p_name varchar(200) not null,
	p_content varchar(2000),
	p_price bigint(20),
	p_mdate datetime not null,
	p_rdate datetime default CURRENT_TIMESTAMP,
	p_img varchar(2000),
	PRIMARY KEY(p_id)
);

DROP TABLE IF EXISTS `tbl_review`;
CREATE TABLE `tbl_review`(
	r_id int(10) not null AUTO_INCREMENT,
	p_id int(10) not null,
	u_email varchar(200),
	u_name varchar(100),
	r_grade varchar(200),
	r_content varchar(2000),
	r_date datetime default CURRENT_TIMESTAMP,
	PRIMARY KEY(r_id)
);

DROP TABLE IF EXISTS `tbl_order`;

CREATE TABLE `tbl_order`(
	o_id int(10) not null AUTO_INCREMENT,
	u_email varchar(100) not null,
	o_price bigint(20) not null,
	o_rfname varchar(100) not null,
	o_rlname varchar(100) not null,
	o_phone varchar(200) not null,
	o_postcode varchar(200) not null,
	o_addr varchar(1000) not null,
	o_state varchar(100) not null,
	o_date datetime default CURRENT_TIMESTAMP,
	PRIMARY KEY(o_id)
);

DROP TABLE IF EXISTS `tbl_order_prod`;
CREATE TABLE `tbl_order_prod`(
	op_id int(10) not null AUTO_INCREMENT,
	o_id int(10) not null,
	p_id int(10) not null,
	op_qty int(10) not null,
	op_sz varchar(100),
	op_type varchar(100),
	op_price bigint(20) not null,
	PRIMARY KEY(op_id)
);

commit;

-- user table sample data
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('freeefly@naver.com', 'DM', 'L', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('minho@naver.com', 'minho', 'Kim', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('park@gmail.com', 'ahu', 'park', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('age@gmail.com', 'sage', 'age', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('sanguin@gmail.com', 'hoho', 'san', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('mage@gmail.com', 'mage', 'god', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('soho@gmail.com', 'commander', 'soldier', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('samagui@gmail.com', 'amy', 'bartigo', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('corti@gmail.com', 'deok', 'sang', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('youngbum@gmail.com', 'yong', 'ji', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('saiko@gmail.com', 'kirimu', 'sasin', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('song@gmail.com', 'hana', 'song', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('samba@gmail.com', 'huiba', 'ah', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('superman@gmail.com', 'man', 'clark', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('spiderman@gmail.com', 'spider', 'man', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('stark@gmail.com', 'iron', 'man', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('torr@gmail.com', 'spy', 'psyco', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('sofa@gmail.com', 'conv', 'sleep', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('sangsang@gmail.com', 'wh', 'nee', '1234');
insert into tbl_user(u_email, u_fname, u_lname, u_pwd)
values ('foreign@gmail.com', 'who', 'think', '1234');

commit;

-- manager table sample data
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('admin@coffeeKong.com', 'best', 'user', 'asdf');
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('asdf@coffeeKong.com', 'best', 'user', 'asdf');
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('shorter@coffeeKong.com', 'short', 'sad', 'asdf');
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('longer@coffeeKong.com', 'long', 'train', 'asdf');
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('bigger@coffeeKong.com', 'big', 'uhm', '123456abc');
insert into tbl_manager(m_email, m_fname, m_lname, m_pwd)
values ('skull@coffeeKong.com', 'pirate', 'creed', '123456abc');

-- product table sample data

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img) values('SingleOrigins', 'Bolivia', 'A clean, sweet, and flavorful coffee that is the result of meticulous artisanal techniques in all levels of production. Our Bolivian coffee is smooth, creamy, and delicious, with notes of chocolate and roasted almond. The light-to-medium roast allows for the soft citrus acidity to shine, striking the perfect balance with the rich and mellow medium body. The processing plant in El Alto used by our farming partners still sorts out defects by hand, a lengthy process which ensures that withered, immature, and insect-damaged beans never make their way into your cup. The result is a coffee which is luscious from beginning to end, all the way through its caramel-like finish.
', 15.99, CURRENT_TIMESTAMP, '/dist/product/bolivia-SingleOrigins.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('SingleOrigins', 'HONDURAS KEDVIN MORENO', 'The Honduras Kedvin Moreno was carefully roasted for you by Tandem Coffee Roasters. This fully washed coffee was grown by the Kedvin Moreno in the Santa Barbara region of Honduras between 1,510 - 1,550 meters above sea level.
We love this coffee for its nuanced notes of spiced pear, chocolate, and floral aroma.', 12.99, CURRENT_TIMESTAMP, '/dist/product/HONDURAS_KEDVIN_MORENO-SingleOrigins.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('SingleOrigins', 'guatemala', 'Clean, sweet, with a classic Central American profile that pairs extremely well with dessert. The notes of cocoa and brown sugar give way to a hint of caramelized apples in the finish. Grown on small family farms high in the Sierra Madre mountain range of Honduras, we have the farmers of the Coprocael cooperative to thank for these beans.
', 13.99, CURRENT_TIMESTAMP, '/dist/product/guatemala-SingleOrigins.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Blends', 'NATURAL HIGH', 'This is the Natural High brought to you by Kaldi''s Coffee Roasting Co. A South and Central American blend of certified Organic and Fair Trade coffees, roasted until most of their essential oils rise to the surface. A classic roast perennially favored in Continental Europe. This cup is fantastically rich, with notes of roasted nuts and caramel.
', 14.99, CURRENT_TIMESTAMP, '/dist/product/NATURAL_HIGH-Blends.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Blends', 'bean martin', 'This is a coffee that we like to show people who think that light roasted single-origins are the only way to go if you''re looking for quality. The flavors in this cup could not exist together were it not for blending, nor could they exist without the deep caramelization of sugars that occurs as a coffee in the roaster approaches second crack. The rich earthiness of Sumatra melds with the sweet bright berry notes of unwashed Ethiopia, taken to a full and robust roast that''s dark without being burnt. A dark roasted Bolivia is blended to unite it all with a rich, creamy body and a hint of chocolate that weaves throughout, resolving in a long and lingering sugary aftertaste. It''s rich, it''s unique, it''s complex.
', 15.99, CURRENT_TIMESTAMP, '/dist/product/bean_martin-Blends.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Blends', 'BLEU ORGANIC', 'This is the Bleu Organic brought to you by La Colombe. This dark filter blend coffee continues our commitment to sourcing coffee from farms that emphasize sustainable practices. Bleu is a seasonal dark roast created with organic USDA coffees from Honduras, Nicaragua, and Peru. With cupping notes of milk chocolate and maraschino cherry, this organic blend is a decadence you can feel good about.
', 18.99, CURRENT_TIMESTAMP, '/dist/product/BLEU_ORGANIC-Blends.jpg');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Decafs', 'ORGANIC DECAF HONDURAS', 'The Organic Decaf Honduras was roasted for you by Kickapoo Coffee Roasters. This decaf coffee is a single origin coffee from Honduras and was decaffeinated using the natural Mountain Water decaffeination method. This cup is rich and full bodied with notes of caramel and chocolate, and is sure to be a crowdpleaser.
', 18.99, CURRENT_TIMESTAMP, '/dist/product/ORGANIC_DECAF_HONDURAS-Decafs.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Decafs', 'Decafs Mexico', 'Nutty, smooth, and medium-bodied. Mellow and sweet with a clean and crisp finish. Water processed decaf means no chemical agent came into contact with your coffee while decaffeinating it. A bright, tangy acidity is softly balanced with its rich body. Hints of brown sugar and cocoa round out the flavor profile, which resolves into a comforting, smooth finish. Our roast profile is not too light, so we pick up on the nice chocolaty notes, but not too dark, so we maintain the acidity. A steady pace during the roast is key to developing the sugars that make this coffee shine.
', 14.99, CURRENT_TIMESTAMP, '/dist/product/decaf_mexico-Decafs.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Decafs', 'Half Caf Blend', 'Aromatic, smooth, perfectly balanced. 50% decaf and 50% caffeinated blend. These two worlds collided and made a star!
', 15.49, CURRENT_TIMESTAMP, '/dist/product/half_caf_blend-Decafs.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Light', 'KENYA KIBUGU', 'This is the Kenya Kibugu brought to you by Quills Coffee. Grown by the various small holder producers in the Embu region at 1,800 meters, this fully washed coffee is a perfect example of why we love coffees from Kenya. We love this coffee for its classic Kenyan cup profile of blackberry and grapefruit.
', 21.99, CURRENT_TIMESTAMP, '/dist/product/KENYA_KIBUGU-Light.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Light', 'WEST END BLUES BLEND', 'The West End Blues Blend was blended and roasted for you by Tandem Coffee Roasters. This combination of coffees create a unique harmony of flavors that are greater than the sum of its parts. This versatile coffee is perfect on its own and lusciously decadent with a bit of cream or steamed milk.
', 18.99, CURRENT_TIMESTAMP, '/dist/product/WEST_END_BLUES_BLEND-Light.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Light', 'Sumatra', 'Sumatran coffee has flavors that some find intense and huge on the palate. Those who love this coffee REALLY love this coffee. One of our most unique and most popular single origin offerings, this coffee is characterized by its striking earthy flavor and its rich, musky tones. A mellow acidity is accompanied by a full body swirling with complex sweetness. Our roast is just dark enough to bring out the deep caramel notes that intertwine with the slightly funky flavors that result from the coffee cherries wet hulling process. The finish is long and exquisitely sweet, an intriguing contrast with the rustic characteristics prevalent at the start of the cup.
', 14.59, CURRENT_TIMESTAMP, '/dist/product/sumatra-Light.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Medium', 'Cowboy Blend', 'Our most popular blend is a bold and rich mix of Indonesian and American coffees. Sumatra brings a rustic earthiness to the cup, which is balanced beautifully with the buttery smoothness of coffee from Nicaragua. Roasted to a level of darkness which brings out a full-bodied sweetness, but not so dark as to obscure the complex combination of flavors in the cup spicy, roasty, and smoky. The secret to this blend is in its slightly unconventional roasting style, which pulls out many tricks from the book of thermodynamics, heat transfer, and airflow in the roasting drum. What makes Cowboy Blend so eminently drinkable is its effortless ability to be both brusque and smooth. If it were a person, you''d call them ruggedly handsome.
', 13.99, CURRENT_TIMESTAMP, '/dist/product/cowboy-Medium.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Medium', 'Dr Mojo', 'This one might be the coffee that is tasted by the most people around us in the Triangle area of North Carolina. Developed to keep the patients and staff at hospitals going 24 hours a day, this blend is smooth and sweet, with a rich creamy body and an inviting mellow acidity. Our medium roast helps the blend components to merge their caramelized sugars into a delicious brew that is both comforting and invigorating.
', 13.99, CURRENT_TIMESTAMP, '/dist/product/dr-mojo-Medium.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Medium', 'BON VIVANT', 'This is the Bon Vivant brought to you by Metric Coffee Co. Creating a blend to achieve a particular flavor profile can be very exciting. It allows us to cup samples from all over, with the goal of finding the perfect coffee, or coffees, to suit their needs. In doing so for Bon Vivant, Metric seeks heirloom variety coffees that find harmony and balance within each layer of this blend. The result is a complex cup with notes of baked apple and citrus.
', 18.99, CURRENT_TIMESTAMP, '/dist/product/BON_VIVANT-Medium.jpg');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Dark', 'NIZZA ESPRESSO BLEND', 'The Nizza Espresso Blend was carefully roasted for you by La Colombe. Nizza is primarily built as an espresso blend, and works well with all brew methods. This cup is fantastically rich, with notes of caramel and nutty.
', 19.49, CURRENT_TIMESTAMP, '/dist/product/NIZZA_ESPRESSO_BLEND-Dark.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Dark', 'Fire in the Belly', 'Xavier Rudd and his posse drink this coffee day &amp; night while on the road. It''s earthy, intense, and smooth. Rich and big with hints of caramel. AND 10% of sales are donated to OXFAM to fight poverty and injustice (their mission is something Xavier cares a lot about, as do we.)
', 14.99, CURRENT_TIMESTAMP, '/dist/product/fire_in_the_belly-Dark.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Dark', 'Frenchy French Roast', 'Some places seem to use their French roasts as an opportunity to hide or obscure a lower quality coffee by roasting it so dark they remove all characteristics of origin, leaving only a cup that tastes of carbon and ash. We don''t see the point in that, so our Frenchy French Roast is a carefully selected coffee, usually from South America, that can withstand the high temperatures of the roast profile which takes it to that nice dark level. We take a slow and steady approach to the roast, allowing the beans natural sugars to caramelize nicely without burning. The result is BOLD, DARK, and RICH with a bittersweet chocolate undercurrent. Roasty and piquant with a warm, inviting aftertaste.
', 13.49, CURRENT_TIMESTAMP, '/dist/product/frenchy_french_roast-Dark.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('grinder', 'BARATZA ENCORE BURR GRINDER', 'The Encore has 40 individual grind settings, from fine to coarse, and has the ability to please any palate with its gamut of accurate and repeatable grind settings. The Encore has an accurate medium to coarse grind for the increasingly popular manual brew methods such as pour-over, Aeropress, French Press and Chemex.
', 130.00, CURRENT_TIMESTAMP, '/dist/product/BARATZA_ENCORE_BURR_GRINDER-grinder.jpg');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('grinder', 'Lido 3 Hand Grinder', 'This Manual Coffee Grinder is built to last and is a personal favorite of Larry''s!&lt;/br&gt; Fresh ground coffee anywhere, for any brewing method and a consistent grind every time. The Lido3 is a fantastic travel grinder!&lt;/br&gt;
Gritty Details: &lt;/br&gt;Swiss made steel conical grinding burr set, it comes with an anti-static brush, a ball driver tool, and a neoprene travel case!', 35.99, CURRENT_TIMESTAMP, '/dist/product/lido3_hand_grinder-grinder.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('grinder', 'Hario Skerton Hand Grinder', 'This Ceramic Coffee Mill is easy to use and easy to clean! It''s perfect for traveling, camping, or when the power goes out.
&lt;/br&gt;Gritty Details&lt;/br&gt;Features conical ceramic burrs, an anti-slip rubber base for easier grinding, the grind setting is easily adjustable, and it''s even dishwasher safe.', 49.99, CURRENT_TIMESTAMP, '/dist/product/hario_skerton_hand_grinder-grinder.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('HomeBrewing', 'Bonmac Ceramic Dripper', 'This classic Single Cup Pour Over Dripper is one of the purest and simplest ways to brew our coffee. It''s all ceramic and it even has a little "window" for monitoring your pour. Ready to use right out of the box!', 13.49, CURRENT_TIMESTAMP, '/dist/product/bonmac_ceramic_dripper-HomeBrewing.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('HomeBrewing', 'Hario Drip Brewer and Decanter', 'This sleek Drip Brewer and Decanter is perfect for pour over brewing. When your finished brewing, remove the plastic dripper and you have a decanter to serve your coffee!&lt;/br&gt;&lt;/br&gt;Gritty Details&lt;/br&gt;Constructed from heat resistant borosilicate glass,
features a removable silicone band, a removable plastic drip brewer and has a capacity of 25-5/8oz.', 36.49, CURRENT_TIMESTAMP, '/dist/product/hario-drip-brewer-and-decanter-HomeBrewing.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('HomeBrewing', 'Hario V60 Drip Scale and Timer', 'This Scale and Timer makes perfecting the your home brewing simple and easy! The scale measures in 0.1 gram increments which make your coffee more consistent than ever before. Not only that, the scale includes a timer to help you perfect every brew.&lt;/br&gt;&lt;/br&gt;
Gritty Details&lt;/br&gt;Minimum weight: 2g &lt;/br&gt;Maximum weight: 2000g (2kg)', 64.49, CURRENT_TIMESTAMP, '/dist/product/hario-v60-drip-scale-and-timer-HomeBrewing.png');

insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Cups', 'Demitasse Cup', 'This 2oz Demitasse Cup has #17 on one side, in honor of our lovely Secret #17 Espresso blend, and our dancing mascot on the other side. This is a must have dinner parties or for your home espresso brewing!
', 4.99, CURRENT_TIMESTAMP, '/dist/product/demitasse_cup-Cups.png');
insert into tbl_prod(p_category, p_name, p_content, p_price, p_mdate, p_img)
values('Cups', 'THE Cowboy Mug', 'This 15oz Cowboy Mug is the mug of choice for many of us here at the bean plant.
We love this mug and we know you will too.', 7.49, CURRENT_TIMESTAMP, '/dist/product/cowboy_mug-Cups.png');

-- order table sample data

commit;
