-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-07-2022 a las 20:33:11
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `librados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entregas`
--

CREATE TABLE `entregas` (
  `id` int(11) NOT NULL,
  `id_ofrecido` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `entregas`
--

INSERT INTO `entregas` (`id`, `id_ofrecido`, `id_usuario`, `fecha`) VALUES
(1, 16, 6, '2022-07-15 14:11:22'),
(2, 5, 11, '2022-07-15 14:29:12'),
(5, 15, 6, '2022-07-15 15:15:28'),
(6, 7, 11, '2022-07-15 15:17:29'),
(7, 14, 6, '2022-07-15 15:18:01'),
(8, 17, 4, '2022-07-15 15:28:57');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `id` int(11) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `titulo` varchar(90) NOT NULL,
  `año` int(11) DEFAULT NULL,
  `edicion` int(11) DEFAULT 1,
  `puntaje` decimal(2,1) DEFAULT 0.0,
  `foto` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`id`, `isbn`, `autor`, `titulo`, `año`, `edicion`, `puntaje`, `foto`) VALUES
(1, '9789500731621', 'Stephen King', 'La milla verde', 2010, 1, '0.0', NULL),
(2, '9781612185439', 'Ian Fleming', 'Casino Royale', 1964, 1, '0.0', NULL),
(3, '9789875661240', 'Stephen King', 'La Niebla', 2006, 1, '0.0', NULL),
(4, '9780321349804', 'Ken Arnold', 'The Java Programming Language', 2005, 4, '0.0', NULL),
(5, '9789385909665', ' Surbhi Kakar', 'A Textbook of Java Programming', 2017, 1, '0.0', NULL),
(6, '9781118441428', 'John Paul Mueller', 'CSS3 For Dummies', 2013, 1, '0.0', NULL),
(7, '9789500766647', 'Isabel Allende', 'Violeta', 2021, 1, '0.0', NULL),
(8, '9789504977261', 'Wolff Tracy', 'Furia', 2022, 1, '0.0', NULL),
(9, '9789504977629', 'Hoover Colleen', 'Verity', 2022, 1, '0.0', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofrecidos`
--

CREATE TABLE `ofrecidos` (
  `id` int(11) NOT NULL,
  `id_libro` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime DEFAULT current_timestamp(),
  `salud` decimal(2,1) DEFAULT 0.0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ofrecidos`
--

INSERT INTO `ofrecidos` (`id`, `id_libro`, `id_usuario`, `fecha`, `salud`) VALUES
(5, 1, 4, '2022-07-12 10:29:13', '4.0'),
(7, 3, 4, '2022-07-12 10:47:56', '2.5'),
(8, 2, 4, '2022-07-12 10:50:39', '4.5'),
(9, 4, 4, '2022-07-12 10:54:18', '3.5'),
(10, 5, 4, '2022-07-12 11:02:55', '5.0'),
(11, 2, 5, '2022-07-13 00:37:43', '4.0'),
(12, 1, 7, '2022-07-13 11:05:34', '3.0'),
(13, 2, 6, '2022-07-13 12:47:50', '2.0'),
(14, 6, 4, '2022-07-14 23:34:52', '5.0'),
(15, 7, 15, '2022-07-15 09:45:57', '5.0'),
(16, 8, 15, '2022-07-15 10:00:50', '4.5'),
(17, 9, 15, '2022-07-15 10:06:04', '5.0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL,
  `id_ofrecido` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `id_ofrecido`, `id_usuario`, `fecha`) VALUES
(4, 9, 11, '2022-07-14 22:58:58'),
(5, 13, 11, '2022-07-14 23:47:03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes`
--

CREATE TABLE `solicitudes` (
  `id` int(11) NOT NULL,
  `id_ofrecido` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `solicitudes`
--

INSERT INTO `solicitudes` (`id`, `id_ofrecido`, `id_usuario`, `fecha`) VALUES
(4, 11, 11, '2022-07-14 06:55:40'),
(7, 12, 11, '2022-07-14 07:18:07'),
(9, 12, 4, '2022-07-14 23:36:24'),
(10, 13, 4, '2022-07-14 23:36:57'),
(11, 11, 4, '2022-07-14 23:42:31'),
(14, 12, 12, '2022-07-15 00:14:26'),
(15, 9, 12, '2022-07-15 00:22:00'),
(18, 8, 13, '2022-07-15 00:27:33'),
(19, 10, 13, '2022-07-15 00:27:37'),
(23, 13, 13, '2022-07-15 00:29:58'),
(24, 13, 14, '2022-07-15 00:32:45'),
(25, 11, 14, '2022-07-15 00:32:49'),
(28, 12, 15, '2022-07-15 09:18:56');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `email` varchar(80) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `puntaje` decimal(2,1) NOT NULL DEFAULT 0.0,
  `latitud` decimal(11,8) DEFAULT NULL,
  `longitud` decimal(10,8) DEFAULT NULL,
  `tipo` enum('user','admin') NOT NULL DEFAULT 'user',
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `nombre`, `email`, `telefono`, `puntaje`, `latitud`, `longitud`, `tipo`, `fecha`) VALUES
(1, 'pepito', 'holamundo', 'Julian', 'pepito@gmail.com', '1174853256', '0.0', '-34.58134516', '-58.48624563', 'user', '2022-07-12'),
(2, 'matete', 'holamundo', 'Mati', 'matute@gmail.com', '1156329632', '0.0', '-34.53563267', '-58.54823740', 'user', '2022-07-12'),
(3, 'gasti56', 'chaumundo', 'Gastón', 'gaston@gmail.com', '1187956371', '0.0', '-34.55564593', '-58.54075471', 'user', '2022-07-12'),
(4, 'juan123', 'juan', 'juan', 'juan@gmail.com', '1185963214', '0.0', '-34.55570450', '-58.46475230', 'user', '2022-07-12'),
(5, 'pamela', 'pamela', 'Pamela', 'pamela@gmail.com', '1123457890', '0.0', '-34.57582151', '-58.54236754', 'user', '2022-07-13'),
(6, 'alberto00', 'chaumundo', 'Alberto', 'alberto6@gmail.com', '1199992222', '0.0', '-34.59638750', '-58.48419818', 'user', '2022-07-13'),
(7, 'ceci45', 'codoacodo', 'Cecilia', 'ceci45@gmail.com', '1198563256', '0.0', '-34.53648732', '-58.52366588', 'user', '2022-07-13'),
(8, 'carlitos', 'carlitos', 'Carlos', 'carlitos@gmail.com', '', '0.0', '-34.50421696', '-58.46162911', 'user', '2022-07-13'),
(9, 'moni99', 'paginaweb', 'Monica', 'monica@gmail.com', '1178963258', '0.0', '-34.52048696', '-58.49421180', 'user', '2022-07-13'),
(10, 'marianito', 'codoacodo', 'Mariano', 'mariano@gmail.com', '1136987458', '0.0', '-34.51025107', '-58.52882001', 'user', '2022-07-13'),
(11, 'patricia22', 'patricia', 'Patricia', 'patricia@gmail.com', '1109453478', '0.0', '-34.56690289', '-58.56425902', 'user', '2022-07-13'),
(12, 'manuelito', 'manuel', 'Manuel', 'manuel@gmail.com', '1134562345', '0.0', '-34.50244362', '-58.52828647', 'user', '2022-07-15'),
(13, 'macarena12', 'macarena', 'Macarena', 'macarena@gmail.com', '1143563087', '0.0', '-34.55894750', '-58.55585068', 'user', '2022-07-15'),
(14, 'ricardito', 'ricardo', 'Ricardo', 'ricardo@gmail.com', '1145639856', '0.0', '-34.57649816', '-58.53690056', 'user', '2022-07-15'),
(15, 'sofia45', 'sofia', 'Sofia', 'sofia@gmail.com', '1189756325', '0.0', '-34.56086150', '-58.55883690', 'user', '2022-07-15');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ofrecido` (`id_ofrecido`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `imdb_UNIQUE` (`isbn`);

--
-- Indices de la tabla `ofrecidos`
--
ALTER TABLE `ofrecidos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_libro` (`id_libro`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ofrecido` (`id_ofrecido`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_ofrecido` (`id_ofrecido`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD UNIQUE KEY `telefono_UNIQUE` (`telefono`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entregas`
--
ALTER TABLE `entregas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `libros`
--
ALTER TABLE `libros`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `ofrecidos`
--
ALTER TABLE `ofrecidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entregas`
--
ALTER TABLE `entregas`
  ADD CONSTRAINT `entregas_ibfk_1` FOREIGN KEY (`id_ofrecido`) REFERENCES `ofrecidos` (`id`),
  ADD CONSTRAINT `entregas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `ofrecidos`
--
ALTER TABLE `ofrecidos`
  ADD CONSTRAINT `ofrecidos_ibfk_1` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id`),
  ADD CONSTRAINT `ofrecidos_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_ofrecido`) REFERENCES `ofrecidos` (`id`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

--
-- Filtros para la tabla `solicitudes`
--
ALTER TABLE `solicitudes`
  ADD CONSTRAINT `solicitudes_ibfk_1` FOREIGN KEY (`id_ofrecido`) REFERENCES `ofrecidos` (`id`),
  ADD CONSTRAINT `solicitudes_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
