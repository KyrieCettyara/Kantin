/*
SQLyog Ultimate v8.55 
MySQL - 5.5.5-10.1.31-MariaDB : Database - db_kantin
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_kantin` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_kantin`;

/*Table structure for table `pemesanan_produk` */

DROP TABLE IF EXISTS `pemesanan_produk`;
CREATE TABLE `pemesanan_produk` (
  `id_pemesanan` INT(11) NOT NULL AUTO_INCREMENT,
  `id_produk` INT(11) DEFAULT NULL,
  `id_user` INT(11) DEFAULT NULL,
  `tanggal_pemesanan` DATETIME DEFAULT NULL,
  `jumlah_harga` DOUBLE DEFAULT NULL,
  `status_bayar` INT(11) DEFAULT '0',
  `status_produk` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id_pemesanan`),
  FOREIGN KEY (id_produk) REFERENCES produk_kantin (id_produk)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `pemesanan_produk` */
SELECT * FROM tempat_duduk;

INSERT  INTO `pemesanan_produk`(`id_pemesanan`,`id_produk`,`id_user`,`tanggal_pemesanan`,`jumlah_harga`,`status_bayar`,`status_produk`) VALUES (1,5,1,'2021-12-12 13:00:00',2000,0,0);

/*Table structure for table `pengiriman` */

DROP TABLE IF EXISTS `pengiriman`;

CREATE TABLE `pengiriman` (
  `id_pengiriman` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pemesanan` INT(11) DEFAULT NULL,
  `tanggal_pengiriman` DATETIME DEFAULT NULL,
  `alamat` VARCHAR(200) DEFAULT NULL,
  `status_pembayaran` INT(11) DEFAULT '0',
  PRIMARY KEY (`id_pengiriman`)
) ENGINE=INNODB DEFAULT CHARSET=latin1;

/*Data for the table `pengiriman` */

/*Table structure for table `produk_kantin` */

DROP TABLE IF EXISTS `produk_kantin`;

CREATE TABLE `produk_kantin` (
  `id_produk` INT(11) NOT NULL AUTO_INCREMENT,
  `nama_produk` VARCHAR(100) DEFAULT NULL,
  `jenis_produk` VARCHAR(100) DEFAULT NULL,
  `stock` INT(11) DEFAULT NULL,
  `harga` DOUBLE DEFAULT NULL,
  `deskripsi` VARCHAR(200) DEFAULT NULL,
  PRIMARY KEY (`id_produk`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


/*Data for the table `produk_kantin` */

INSERT  INTO `produk_kantin`(`id_produk`,`nama_produk`,`jenis_produk`,`stock`,`harga`,`deskripsi`) VALUES 
(1,'Tempe','Makanan',2000,2000,'Makanan yang terbuat dari kedelai'),
(2,'Lele','Makanan',2000,2000,'Ikan lele yang di potong kecil kecil'),
(3,'Cap cay','Makanan',1000,5000,'Bermacam sayuran yang dimasak dengan minyak zaitun'),
(4,'Ikan teri','Makanan',2000,12000,'Ikan teri kualitas premium yang dipilih melalui seleksi yang lulus uji ITB dan IPB'),
(5,'Jus Mangga','Minuman',2000,20000,'Jus mangga yang diurus dengan cinta menghasillkan mangga pilihan yang sangat manis dan juicy'),
(6,'Green Tea','Minuman',2000,12000,'Dengan pucuk teh pilihan yang diolah dengan kasih'),
(7,'Terong Sambal','Makanan',2000,12000,'Terong yang dipotong potong kemudian diberi bumbu sambal'),
(8,'Banana Smoothies','Minuman',2000,20000,'Pisang pilihan yang diolah bersamaan dengan susu dari sapi yang diternak khusus dengan potongan pisang sebagai topping'),
(9,'Matcha','Minuman',2000,20000,'Dengan bubuk matcha yang dikirim langsung dari Jepang, disajikan dengan susu premium dan topping ice cream buatan sendiri'),
(10,'Air Putih','Minuman',2000,20000,'Air berasal dari gunung kemudian disaring dan telah lulus uji oleh ITB dan IPB');/*Table structure for table `tempat_duduk` */

DROP TABLE IF EXISTS `tempat_duduk`;

CREATE TABLE `tempat_duduk` (
  `id_seat` INT NOT NULL AUTO_INCREMENT,
  `no_seat` VARCHAR(10) DEFAULT NULL,
  `status` INT DEFAULT NULL,
  `id_user` INT DEFAULT NULL,
  `waktu_pemesanan` DATETIME DEFAULT NULL,
  `waktu_expired` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id_seat`)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `tempat_duduk` */

INSERT  INTO `tempat_duduk`(`id_seat`,`no_seat`,`status`) VALUES 
(1,'KL-01',0),
(2,'KL-02',0),
(3,'KL-03',0),
(4,'KL-04',0),
(5,'KL-05',0),
(6,'KL-06',0),
(7,'KL-07',0),
(8,'KL-08',0),
(9,'KL-09',0),
(10,'KL-10',0),
(11,'KL-11',0),
(12,'KL-12',0),
(13,'KL-13',0),
(14,'KL-14',0),
(15,'KL-15',0),
(16,'KL-16',0),
(17,'KL-17',0),
(18,'KL-18',0),
(19,'KL-19',0),
(20,'KL-20',0);

SELECT * FROM tempat_duduk


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
