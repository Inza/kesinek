SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `isInBasket`;

CREATE TABLE `isInBasket` (
  `isInBasketID` int(11) NOT NULL auto_increment,
  `basketID` int(11) NOT NULL,
  `productItemID` int(11) NOT NULL,
  PRIMARY KEY  (`isInBasketID`),
  KEY `productItemID` (`productItemID`),
  KEY `basketID` (`basketID`),
  CONSTRAINT `iiBasketFK` FOREIGN KEY (`basketID`) REFERENCES `Basket` (`basketID`),
  CONSTRAINT `iiProductItemFK` FOREIGN KEY (`productItemID`) REFERENCES `ProductItem` (`productItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `isInCategory`;

CREATE TABLE `isInCategory` (
  `categoryID` int(11) NOT NULL,
  `productItemID` int(11) NOT NULL,
  `isInCategoryID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`isInCategoryID`),
  KEY `productItemID` (`productItemID`),
  KEY `categoryID` (`categoryID`),
  CONSTRAINT `iiCategoryFK` FOREIGN KEY (`categoryID`) REFERENCES `Category` (`categoryID`),
  CONSTRAINT `iiProductFK` FOREIGN KEY (`productItemID`) REFERENCES `ProductItem` (`productItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `isInCategory` values('1','1','1'),
 ('2','1','2'),
 ('1','2','3');

DROP TABLE IF EXISTS `isInPurchaseOrder`;

CREATE TABLE `isInPurchaseOrder` (
  `isInPurchaseOrderID` int(11) NOT NULL auto_increment,
  `purchaseOrderID` int(11) NOT NULL,
  `productItemID` int(11) NOT NULL,
  PRIMARY KEY  (`isInPurchaseOrderID`),
  KEY `productItemID` (`productItemID`),
  KEY `purchaseOrderID` (`purchaseOrderID`),
  CONSTRAINT `orderFK` FOREIGN KEY (`purchaseOrderID`) REFERENCES `PurchaseOrder` (`purchaseOrderID`),
  CONSTRAINT `productFK` FOREIGN KEY (`productItemID`) REFERENCES `ProductItem` (`productItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `isInWishlist`;

CREATE TABLE `isInWishlist` (
  `isInWishlistID` int(11) NOT NULL auto_increment,
  `wishlistID` int(11) NOT NULL,
  `productItemID` int(11) NOT NULL,
  PRIMARY KEY  (`isInWishlistID`),
  KEY `productItemID` (`productItemID`),
  KEY `wishlistID` (`wishlistID`),
  CONSTRAINT `proFK` FOREIGN KEY (`productItemID`) REFERENCES `ProductItem` (`productItemID`),
  CONSTRAINT `wishlistFK` FOREIGN KEY (`wishlistID`) REFERENCES `Wishlist` (`wishlistID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `Basket`;

CREATE TABLE `Basket` (
  `basketID` int(11) NOT NULL auto_increment,
  `userID` int(11) NOT NULL,
  PRIMARY KEY  (`basketID`),
  KEY `userID` (`userID`),
  KEY `userID_2` (`userID`),
  CONSTRAINT `basketsFK` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Basket` values('1','1');

DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
  `description` varchar(50) default NULL,
  `name` varchar(50) NOT NULL,
  `categoryID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`categoryID`),
  KEY `categoryID` (`categoryID`),
  KEY `categoryID_2` (`categoryID`),
  KEY `categoryID_3` (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Category` values('bum','Kulomety','1'),
 ('ratatatata','Zbran?','2');

DROP TABLE IF EXISTS `CategoryAttribute`;

CREATE TABLE `CategoryAttribute` (
  `description` varchar(50) default NULL,
  `name` varchar(50) NOT NULL,
  `categoryAttributeID` int(11) NOT NULL auto_increment,
  `categoryID` int(11) NOT NULL,
  PRIMARY KEY  (`categoryAttributeID`),
  KEY `categoryID` (`categoryID`),
  KEY `categoryID_2` (`categoryID`),
  CONSTRAINT `categoryAttributesFK` FOREIGN KEY (`categoryID`) REFERENCES `Category` (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `CategoryAttribute` values('Dostrel je nice','Dostrel','1','2'),
 ('Raze je jak tunel','Raze','2','2'),
 ('Kadence jak syr','Kadence','3','1');

DROP TABLE IF EXISTS `Event`;

CREATE TABLE `Event` (
  `date` datetime NOT NULL,
  `text` varchar(50) NOT NULL,
  `eventID` int(11) NOT NULL auto_increment,
  `userID` int(11) NOT NULL,
  PRIMARY KEY  (`eventID`),
  KEY `userID` (`userID`),
  KEY `userID_2` (`userID`),
  CONSTRAINT `eventsFK` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Event` values('2009-12-13 12:03:37','Uživatel User se vysmrkal','1','1'),
 ('2009-12-12 12:04:05','Uživatel User se odhlásil','2','1'),
 ('2009-12-13 12:04:25','U?ivatel Admin šel na WC','3','2');

DROP TABLE IF EXISTS `Favorite`;

CREATE TABLE `Favorite` (
  `favoritesID` int(11) NOT NULL auto_increment,
  `favoritesName` varchar(50) NOT NULL,
  PRIMARY KEY  (`favoritesID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Favorite` values('1','');

DROP TABLE IF EXISTS `Manufacturer`;

CREATE TABLE `Manufacturer` (
  `name` varchar(50) NOT NULL,
  `manufacturerID` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`manufacturerID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Manufacturer` values('SSSR','1');

DROP TABLE IF EXISTS `ProductAttribute`;

CREATE TABLE `ProductAttribute` (
  `attributeValue` varchar(50) NOT NULL,
  `productAttributeID` int(11) NOT NULL auto_increment,
  `productItemID` int(11) NOT NULL,
  `categoryAttributeID` int(11) NOT NULL,
  PRIMARY KEY  (`productAttributeID`),
  KEY `productItemID` (`productItemID`),
  KEY `productItemID_2` (`productItemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `ProductAttribute` values('100','1','1','1'),
 ('3','2','1','2'),
 ('5','3','1','3'),
 ('2','4','2','3');

DROP TABLE IF EXISTS `ProductItem`;

CREATE TABLE `ProductItem` (
  `amount` int(11) default '1',
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL,
  `productItemID` int(11) NOT NULL auto_increment,
  `manufacturerID` int(11) NOT NULL,
  `warehouseID` int(11) NOT NULL,
  PRIMARY KEY  (`productItemID`),
  KEY `manufacturerID` (`manufacturerID`),
  KEY `productItemID` (`productItemID`),
  KEY `warehouseID` (`warehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `ProductItem` values('1','Kulomet AK-47','10000','1','1','1'),
 ('42','Minigan MKII','20','2','1','1'),
 ('3','Kulomet AK-47','10000','3','1','1'),
 ('2','Kulomet AK-47','10000','4','1','1');

DROP TABLE IF EXISTS `PurchaseOrder`;

CREATE TABLE `PurchaseOrder` (
  `purchaseOrderID` int(11) NOT NULL auto_increment,
  `userID` int(11) NOT NULL,
  PRIMARY KEY  (`purchaseOrderID`),
  KEY `userID` (`userID`),
  KEY `userID_2` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `PurchaseOrder` values('1','1');

DROP TABLE IF EXISTS `Role`;

CREATE TABLE `Role` (
  `name` varchar(50) NOT NULL,
  `roleID` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY  (`roleID`),
  KEY `userID` (`username`),
  KEY `userID_2` (`username`),
  KEY `userID_3` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Role` values('Admin','1','2'),
 ('User','2','1');

DROP TABLE IF EXISTS `User`;

CREATE TABLE `User` (
  `address` varchar(50) default NULL,
  `password` varchar(50) default NULL,
  `username` varchar(50) default NULL,
  `userID` int(11) NOT NULL,
  PRIMARY KEY  (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `User` values('U Popelnic 16, Praha 3','abcde','User','1'),
 ('Pod Mostem 5, Sme?ák 8','efghi','Admin','2');

DROP TABLE IF EXISTS `Warehouse`;

CREATE TABLE `Warehouse` (
  `warehouseID` int(11) NOT NULL auto_increment,
  `description` text NOT NULL,
  PRIMARY KEY  (`warehouseID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Warehouse` values('1','Sklad 1'),
 ('2','Sklad 2');

DROP TABLE IF EXISTS `Wishlist`;

CREATE TABLE `Wishlist` (
  `wishlistID` int(11) NOT NULL auto_increment,
  `userID` int(11) NOT NULL,
  PRIMARY KEY  (`wishlistID`),
  KEY `userID` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into `Wishlist` values('1','1'),
 ('2','2');

SET FOREIGN_KEY_CHECKS = 1;
