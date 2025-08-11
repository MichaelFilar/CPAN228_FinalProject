All the database code/schemas for creating the correct databases (on XAMPP) are below:

Journal Database code
CREATE TABLE `journals` (
  `id` bigint(20) NOT NULL,
  `userid` bigint(20) NOT NULL,
  `contents` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

Sample data
INSERT INTO `journals` (`id`, `userid`, `contents`, `date`) VALUES
(1, 123, 'test 3', '2025-08-09'),
(2, 123, 'hello world\r\n', '2025-08-08'),
(3, 123, 'hello world\r\n', '2025-08-07');

Mood database code
CREATE TABLE `moods` (
  `id` bigint(20) NOT NULL,
  `userID` bigint(20) NOT NULL,
  `moodvalue` varchar(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

Sample data
INSERT INTO `moods` (`id`, `userID`, `moodvalue`, `date`) VALUES
(1, 123, 'Happy, '2025-08-09'),
(2, 123, 'Sad', '2025-08-10');
