# Projekt Leírás:

Az én szorgalmi projektemben egy olyan alkalmazás vázat próbáltam megvalósítani amivel a játékokban fellelhető hibákat lehet követni mint termék - panasz nyilvántartás. Ezzel a rendszerrel lehetne a felhasználóktól érkező megjegyzéseket tárolni és nyomon követni a hibákat. 

# Relációs Séma:

![Alt text](img/dis.PNG?raw=true "dis")

# Réteg Funkcionális Terve:

Az alkalmazás jelen pillanatban konzolról indítva működik ahol egy kezdetleges menüt valósítottam meg. 

![alt text](img/menu.PNG "menu")

Első lépésben ellenőrizzük a JDBC driver-t és csatlakozunk a SQLite adatbázisokhoz.

![alt text](img/connect.PNG)

Ezután megjelenik a  menü ahol a számát kiválasztva hajtja végre a feladatát. 

![alt text](img/menu.PNG)

A 0-val bezárjuk a programot és megszakítjuk a kapcsolatot.

![alt text](img/dis.PNG)

A 1-sel katalógussal tudjuk listázni a termék adatbázisban lévő termékeket.

![alt text](img/termekLista.PNG)

A 2-sel be tudunk nyújtani egy panaszt amit az adatbázisban mentünk el. Először is meg kell adnunk a termék kódját, az email címet, a panasz címét, a panasz bővebb leírását és végül, hogy a panasz mikor lett felfedezve. A PanaszID-t a rendszer magától generálja és a dátum formátumot is ellenőrzi a rendszer. 

![alt text](img/panasz.PNG)

A 3-sal az eddigi összes panaszt ki tudjuk listázni az adatbázisból. 

![alt text](img/pl1.PNG)
![alt text](img/pl2.PNG)
![alt text](img/pl3.PNG)

A 4-sel pedig a TermékID-ja alapján tudjuk listázni a termékhez tartozó panaszokat. 

![alt text](img/pl44.PNG)

# Forráskód:
https://github.com/marcibaumel/O09CTQ_DB2_Szorgalmi_1/tree/master/src

