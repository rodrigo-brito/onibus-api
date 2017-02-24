INSERT INTO `company` (`id`, `image_url`, `name`, `description`) VALUES
(1, 'http://rodrigobrito.net/wp-content/uploads/2017/02/onibus_foto.jpg', 'Vinscol', 'Linha municipal'),
(2, 'http://rodrigobrito.net/wp-content/uploads/2017/02/onibus_2.jpg', 'Cisne', 'Linha intermunicipal');

INSERT INTO `bus` (`id`, `fare`, `name`, `number`, `company_id`) VALUES
(1, 4.8, 'BH - Sabará', '4988', 2),
(2, 6.1, 'Executivo', '4987', 2);

INSERT INTO `day_type` (`id`, `active`, `name`) VALUES
(1, b'1', 'Dia Útil'),
(2, b'1', 'Sábado / Feriado');

INSERT INTO `schedule` (`id`, `destiny`, `observation`, `origin`, `time`, `bus_id`, `daytype_id`) VALUES
(1, 'BH', 'Normal', 'Sabará', '12:00:00', 1, 1),
(2, 'BH', 'Normal', 'Sabará', '13:00:00', 1, 1),
(3, 'BH', 'Normal', 'Sabará', '14:00:00', 1, 1);