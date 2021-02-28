# Projekt Leírás:

Az én szorgalmi projektemben egy olyan alkalmazás vázat próbáltam megvalósítani amivel a játékokban fellelhető hibákat lehet követni mint termék - panasz nyilvántartás. Ezzel a rendszerrel lehetne a felhasználóktól érkező megjegyzéseket tárolni és nyomon követni a hibákat. 

# Relációs Séma:

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/schema.PNG)

# Réteg Funkcionális Terve:

Az alkalmazás jelen pillanatban konzolról indítva működik ahol egy kezdetleges menüt valósítottam meg. 

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/menu.PNG)

Első lépésben ellenőrizzük a JDBC driver-t és csatlakozunk a SQLite adatbázishoz.

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/connect.PNG)

Ezután megjelenik a  menü ahol a számát kiválasztva hajtja végre a feladatát. 

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/menu.PNG)

A 0-val bezárjuk a programot és megszakítjuk a kapcsolatot.

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/dis.PNG)

A 1-sel katalógussal tudjuk listázni a termék adatbázisban lévő termékeket.

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/termekLista.PNG)

A 2-sel be tudunk nyújtani egy panaszt amit az adatbázisban mentünk el. Először is meg kell adnunk a termék kódját, az email címet, a panasz címét, a panasz bővebb leírását és végül, hogy a panasz mikor lett felfedezve. A PanaszID-t a rendszer magától generálja és a dátum formátumot is ellenőrzi a rendszer. 

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/panasz.PNG)

A 3-sal az eddigi összes panaszt ki tudjuk listázni az adatbázisból. 

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/pl1.PNG)
![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/pl2.PNG)
![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/pl3.PNG)

A 4-sel pedig a TermékID-ja alapján tudjuk listázni a termékhez tartozó panaszokat. 

![alt text](https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/blob/master/pl44.PNG)

# Forráskód:
https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/tree/master/src

