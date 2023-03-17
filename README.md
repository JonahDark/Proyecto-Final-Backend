# Proyecto-Final-Backend

Aquí dejo los scrpits SQL para rellenar la BBDD y poder cargar la aplicación correctamente.

INSERT INTO ubicacion (aforo, nombre, precio, tipo, descripcion, foto)
VALUES
	(200, 'Jardín Luna', 599.90, 'jardin', 'Jardín pensado para eventos nocturnos por sus hermostas vistas al cielo', 'https://i.postimg.cc/WbrMsRzk/jardin-luna.png'),
	(300, 'Jardín Bosque', 699.90, 'jardin', 'Jardín ubicado entre arboles del bosque', 'https://i.postimg.cc/tRsctgvG/jardin-bosque.jpg'),
	(500, 'Jardín Mediterraneo', 899.90, 'jardin', 'Jardín ubicado en un mirador con vistas al mar ', 'https://i.postimg.cc/FFn4Nq8N/jardin-mediterraneo.jpg'),
	(400, 'Sala Carpa', 599.90, 'sala', 'Sala tapizada con seda y rodeada de grandes ventanales', 'https://i.postimg.cc/5N7qP5XP/sala-carpa.jpg'),
	(5, 'Sala Feng', 399.90, 'sala', 'Sala con ambientación oriental', 'https://i.postimg.cc/DZ3wnNMx/sala-feng.jpg'),
	(500, 'Sala Roma', 899.90, 'sala', 'Sala con ambientacion romana', 'https://i.postimg.cc/Qd5pb21b/sala-roma.jpg');
  
INSERT INTO decoracion (foto, nombre, precio, tipo)
VALUES 
	('https://i.postimg.cc/rFL6wnv3/wedding-g0f331c8f1-640.jpg', 'Decoración Premium', 200.00, 'PREMIUM'),
  ('https://i.postimg.cc/tTMXc3Jy/event-photography-gad8cd5baa-640.jpg', 'Decoración Standard', 100.00, 'STANDAR'),
  ('https://i.postimg.cc/Wbn2LchX/books-g4a04bfd49-640.jpg', 'Decoración Low-Cost', 75.00, 'LOWCOST');
  
INSERT INTO menu (foto, nombre, precio_menu, precio_menu_alergeno, precio_menu_alergeno_infantil, precio_menu_infantil, tipo)
VALUES 
  ('https://i.postimg.cc/xCmYJdLY/roast-duck-g2705561b9-640.jpg', 'Menú Premium', 200.00, 179.90, 159.90, 149.90, 'PREMIUM'),
  ('https://i.postimg.cc/FRgVGy4K/thai-food-gd92d447ec-640.jpg', 'Menú Standard', 100.00, 79.90, 69.90, 59.90, 'STANDAR'),
  ('https://i.postimg.cc/05M4G36W/goulash-g64d9cdd59-640.jpg', 'Menú Low-Cost', 75.00, 60.00, 50.00, 40.00, 'LOWCOST');


