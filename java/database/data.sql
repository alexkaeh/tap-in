-- insert brewery
insert into brewery (brewery_id, brewery_name, contact_info, address, is_active)
values
(2001, 'Black Dog Brewing', '(317) 318-8448', '11230 IN-67, Mooresville, IN 46158', true),
(2002, 'Braxton Barrel House', '859-261-5600', '5 Orphanage Rd, Fort Mitchell, KY 41017', true),
(2003, 'Sonder Brewing', '(513) 779-2739', '8584 Duke Blvd, Mason, OH 45040', true),
(2004, 'Grove City Brewing Company', '(614) 991-0338', '3946 Broadway, Grove City, OH 43123', true),
(2005, 'Barnhouse Brewery', '(703) 675-8480', '43271 Spinks Ferry Rd, Leesburg, VA 20176', true);

-- insert hours of operation

-- insert beer
insert into beer (beer_id, brewery_brewery_id, beer_name, description, abv, beer_type, is_active)
values
(3001, 2001, 'Good Vibrations', 'Using his secret "Good Vibrations blend," our brew master has crafted a white ale that shares a complexity of spice flavors while keeping it real with a mild tartness and zesty orange flavor. A little summertime chillin with mans best friend and a refreshing Good Vibrations Spiced White Ale is just what the doctor ordered.', 4.8, 'Wheat Beer', true),
(3002, 2001, 'Dillinger Brown Ale', 'An American Brown Ale from the hometown of John H. Dillinger Jr. Deep roasted malt flavors give way to slightly dry, nutty finish.', 6.5, 'American Brown Ale', true),
(3003, 2002, 'Dead Blow', 'This tropical stout is a spin on the more traditional Foreign Extra Stout. Eighty pounds of Macerated Dates made its way into this brew, partnered with a Dry English Ale yeast to provide a vibrant fruity/tropical aroma with a slight amount of fruity esters. The Dry English ale yeast helps this beer attenuate lower, however leaving a residual sweetness on the finish as well as increase the fruity characteristic received from the Dates. Dead Blow is a dry, roasty, fruity, full bodied, smooth stout, that is lighter on bitterness.', 7.2, 'Foreign Stout', true),
(3004, 2002, 'Roadtrip', 'This tropical delight is loaded with hundreds of pounds of passionfruit, orange and guava juices to bring this classic hawaiian combination to the beer world. The Low amount of hops that are balanced with the subtle acidity lets this delicious tropical Berliner be an oasis in the upcoming cold weather.', 4.2, 'Sour', true),
(3005, 2003, 'Road to Casablanca', 'Fermented and aged in French Oak puncheons, this American wild ale was then conditioned atop an expressive tea blend which included apple, rosehip, and elderberry. Gleaming with a light purple color, and a spritzy carbonation, Road to Casa Blanca is a tart, fruity delight that can easily be enjoyed on your way to the desert.', 5.3, 'American Wild Ale', false),
(3006, 2003, 'You Betcha!', '2019 Cincinnati IPA Madness Winner. A hoppy, hazy, tropical fruit explosion with a juicy and soft texture leaving bitterness behind.', 6.5, 'New England IPA', true),
(3007, 2004, 'Grove City Beulah', 'Light and refreshing blonde dry hopped with citra hops.', 4.3, 'Blonde Ale', true),
(3008, 2004, 'Grove City Bossy Blonde', 'Blonde Stout with lighter malt sweetness, notes of chocolate, vanilla, almond, honey. Made with coffee from The Coffee Mess Roastery.', 8.0, 'Stout', true),
(3009, 2005, 'Banshee Irish Red', 'A malt-focused easy drinking beer that exhibits some malt sweetness followed by some light roast, and finishes somewhat dry. We use English pale malt, a touch of crystal malt , roasted barley, and English hops.', 5.5, 'Malt', true),
(3010, 2005, 'Lost City IPA', 'This is an East coast IPA but is not hazy... Juicy hops such as Mosaic and El Dorado highlight this wonderful IPA.', 7.6, 'IPA', true);
