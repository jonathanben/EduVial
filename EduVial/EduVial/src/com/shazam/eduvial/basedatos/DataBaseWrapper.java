package com.shazam.eduvial.basedatos;

	import android.content.Context;
	import android.database.sqlite.SQLiteDatabase;
	import android.database.sqlite.SQLiteOpenHelper;

	public class DataBaseWrapper extends SQLiteOpenHelper {
		
		
		// Tabla y atributos de Categor�a
		public static final String CATEGORIA = "Categoria";
		public static final String CODCATEGORIA = "codCategoria";
		public static final String NOMBRE = "nombre";
		
		// Tabla y atributos de Infracci�n
		public static final String INFRACCION = "Infraccion";
		public static final String CODINFRACCION = "codInfraccion";
		public static final String MONTO = "monto";
		public static final String DESCRIPCION = "descripcion";

		// Base de datos y versi�n
		private static final String DATABASE_NAME = "eduvial.db";
		private static final int DATABASE_VERSION = 2;
		
		// creation SQLite statement
		private static final String DATABASE_CREATE = "create table " + CATEGORIA + "(" + CODCATEGORIA + " integer primary key autoincrement, " + NOMBRE + " text not null);" ;
									
									
													  		
		//private static final String DATOS_INFRACCION = "INSERT INTO Infraccion values (1, 5000, 'Conducir en estado de embriaguez extrema: concentraci�n superior a 2 gramos de alcohol por litro de sangre. Vi�eta 1. Arto 26.',1), (2, 4000, 'Conducir en estado de embriaguez: concentraci�n de m�s de 1 gramo hasta 2 gramos de alcohol por litro de sangre. Vi�eta 2. Arto 26.',1), (3, 4000, 'Conducir bajo efectos de estupefacientes, psicotr�picos, estimulantes y sustancias controladas. Vi�eta 3. Arto 26.',1), (4, 3000, 'Conducir de forma temeraria. Vi�eta 4. Arto 26.',2), (5, 2500, 'Provocar accidente y darse a la fuga. Vi�eta 5. Arto 26.',3), (6, 2500, 'Conducir a velocidad mayor que la que se exprese en la se�alizaci�n de tr�nsito o al est�ndar establecido. Vi�eta 6. Arto 26.',5), (7, 1000, 'Estacionar en carretera, trailers, rastras y contenedores sin tri�ngulos reflectivos u otras se�ales lum�nicas adecuadas para la prevenci�n de accidentes. Vi�eta 7. Arto 26.',4), (8,1000, 'Giros indebidos en U y Zigzag. Vi�eta 8. Arto 26.',5), (9,1000,'Usar placas y/o circulaci�n de otro veh�culo. Vi�eta 9. Arto 26.',8), (10,800,'Invasi�n de carril. Vi�eta 10. Arto 26.',2), (11,500,'Trasladar mercader�a o carga a granel sin la protecci�n total de carpas o lonas. Vi�eta 11. Arto 26.',4), (12,1000,'Participar en competencias ilegales de automotores. Vi�eta 12. Arto 26.',5), (13,500,'Conducir sin tener licencia de conducir. Vi�eta 13. Arto 26.',6), (14,650,'No respetar la preferencia peatonal en las intersecciones o los cruces de colegios. Vi�eta 14. Arto 26.',1), (15,500,'Exceso de pasajeros o de carga. Vi�eta 15. Arto 26.',6), (16,500,'Aventajar en pendientes, curvas o puentes. Vi�eta 16. Arto 26.',5), (17,500, 'Conducir con las luces apagadas despu�s de la hora indicada, o durante el d�a cuando haya condiciones ambientales de lluvia, neblina o tolvanera. Vi�eta 17. Arto 26.',7), (18,500,'Adelantar en l�nea continua amarilla. Vi�eta 18. Arto 26.',5), (19,500,'Conducir contra la v�a. Vi�eta 19. Arto 26.',5), (20,500,'Obstrucci�n de la libre circulaci�n vehicular. Vi�eta 20. Arto 26.',7), (21,500,'El conductor de motocicleta y acompa�ante que circulen sin portar debidamente el casco. Vi�eta 21. Arto 26.',7), (22,350,'El conductor y acompa�antes de un veh�culo automotor, que no utilice el cintur�n de seguridad. Vi�eta 22. Arto 26.',7), (23,350,'Desatender se�ales de emergencia, lum�nicas, sonoras de ambulancias, polic�a o bomberos. Vi�eta 23. Arto 26.',7), (24,250,'Conducir utilizando manualmente tel�fonos m�viles, o cualquier otro aparato de distracci�n en el manejo. Vi�eta 24. Arto 26',7), (25,500,'No reportar los cambios de las caracter�sticas f�sicas del veh�culo. Vi�eta 25. Arto 26',8), (26,650,'Conducir con las puertas abiertas, transporte colectivo y de carga. Vi�eta 26. Arto 26',7), (27,350,'Conducir carga sin la debida se�alizaci�n visible o reflectiva apropiada. Vi�eta 27. Arto 26',9), (28,350,'Estacionarse en la v�a p�blica, en caso de emergencia, sin tri�ngulos reflectivos u otras se�ales lum�nicas adecuadas para la prevenci�n de accidentes. Vi�eta 28. Arto 26',4), (29,350,'Transportar ni�os menores de siete a�os en el asiento delantero o en asientos posteriores de veh�culos sin cintur�n de seguridad o sistema de protecci�n o retenci�n infantil. Vi�eta 29. Arto 26',7), (30,350,'Desatender se�ales de tr�nsito, verticales u horizontales, siempre que est�n visibles. Vi�eta 23. Arto 30',3), (31,200,'Conducir motocicletas con ni�os menores de 8 a�os. Vi�eta 31. Arto 26',7), (32,700,'Conducir cuadraciclos en ciudades y �reas no autorizadas por la Polic�a Nacional. Vi�eta 32. Arto 26',9), (33,500,'Conducir veh�culos que provocan exceso de humo. Vi�eta 33. Arto 26',9), (34,1000,'Conducir en estado de embriaguez ligera: Concentraci�n superior a 0.5 gramos hasta 1 gramo de alcohol por litro de sangre. Vi�eta 34. Arto 26',1), (35,250,'Conducir cuadraciclos o triciclos sin utilizar debidamente el casco t�cnicamente adecuado. Vi�eta 35. Arto 26',9), (36,250,'Conducir de retroceso en la v�a p�blica. Vi�eta 36. Arto 26',2), (37,250,'Aventajar por la derecha en v�as de un solo carril. Vi�eta 37. Arto 26',2), (38,250,'Subir pasajeros fuera de la bah�a o lugares no establecidos como paradas. Vi�eta 38. Arto 26',9), (39,250,'Bajar o subir pasajeros por el lado izquierdo en la v�a p�blica. Vi�eta 39. Arto 26',9), (40,250,'Realizar se�ales equivocadas sobre sus maniobras al conducir. Vi�eta 40. Arto 26',7), (41,250,'Conducir veh�culo en mal estado mec�nico. Vi�eta 41. Arto 26',7), (42,450,'Provocar ruidos escandalosos y perturbadores del medio ambiente. Vi�eta 42. Arto 26',7), (43,250,'Circular con los veh�culos sobre bulevares, aceras o andenes. vi�eta 43. Arto 26',2), (44,250,'No portar tri�ngulos fluorescentes o extinguidor. Vi�eta 45. Arto 26',9), (45,160,'No guardar la distancia entre uno y otro veh�culo. Vi�eta 46. Arto 26',9), (46,160,'Estacionarse: a) Sobre aceras y andenes. b) Frente a hidrantes. c) Frente a garajes. d) En las entradas de hospitales y cl�nicas. e) En los estacionamientos habilitados para personas con discapacidad, accesos o rampas para discapacitados. f) En paradas de buses, particulares o transporte selectivo. g) En rotondas. Vi�eta 47. Arto 26',4), (47,320,'Tirar basura o desechos en la v�a p�blica desde veh�culos automotores de uso p�blico o privado. Vi�eta 48. Arto 26',7), (48,320,'Conducir sin portar placas o licencia de circulaci�n. Vi�eta 49. Arto 26',9), (49,320,'Conducir con licencia en categor�as diferentes a la autorizada. Vi�eta 50. Arto 26',8), (50,320,'Transporte urbano colectivo, no detenerse a subir o bajar pasajeros en las paradas definidas por la autoridad correspondiente. Vi�eta 51. Arto 26',9), (51,320,'Circular con placas no visibles, en mal estado o no autorizadas. Vi�eta 52. Arto 26',8), (52,320,'Conducir con calcoman�a de revisado sin vigencia. Vi�eta 53. Arto 26',8), (53,320,'Prestar servicio de transporte p�blico sin la debida autorizaci�n. Vi�eta 54. Arto 26',8), (54,320,'Conducir automotores con el certificado o calcoman�a de emisi�n de gases o el certificado de inspecci�n mec�nica sin vigencia. Vi�eta 55. Arto 26',8),(55,250,'Conducir con la licencia vencida. Vi�eta 56. Arto 26',8), (56,160,'Conducir transporte colectivo fuera de la ruta o servicio no autorizado. Vi�eta 57. Arto 26',9), (57,160,'Conducir sin portar licencia. Vi�eta 58. Arto 26',9), (58,160,'Circular sin loderas en las llantas traseras de veh�culos de carga o pasajeros. Vi�eta 59. Arto 26',9), (59,160,'Circular sin espejos retrovisor interno o lateral. Vi�eta 60. Arto 26',7), (60,200,'Obstruir la visibilidad en los vidrios del veh�culo utilizando polarizado no autorizado. Vi�eta 61. Arto 26',9), (61,100,'Circular en bicicletas o medios de transporte de tracci�n animal sin se�ales lum�nicas visibles. Vi�eta 62. Arto 26',7), (62,100,'Circular sin la calcoman�a del pago de impuesto de rodamiento. Vi�eta 63. Arto 26',9);";
		
		public DataBaseWrapper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
						
			db.execSQL(DATABASE_CREATE);
		
			db.execSQL("CREATE TABLE Infraccion (codInfraccion INTEGER PRIMARY KEY AUTOINCREMENT,"+
					"monto FLOAT NOT NULL, descripcion VARCHAR(100) NOT NULL, codCategoria INTEGER," +
					"FOREIGN KEY (codCategoria) REFERENCES Categoria(CodCategoria));");
			
			db.execSQL("INSERT INTO Categoria values (1, 'Alcohol y Drogas');");
			db.execSQL("INSERT INTO Categoria values (2,'Conducci�n Peligrosa');");
			db.execSQL("INSERT INTO Categoria values (3, 'Accidentar y/o Huir');");
			db.execSQL("INSERT INTO Categoria values (4, 'Mal estacionamiento');");
			db.execSQL("INSERT INTO Categoria values (5, 'Conducci�n Agresiva');");
			db.execSQL("INSERT INTO Categoria values (6,'Trasladar mercanc�a');");
			db.execSQL("INSERT INTO Categoria values (7, 'Imprudencia');");
			db.execSQL("INSERT INTO Categoria values (8,'Fraude');");
			db.execSQL("INSERT INTO Categoria values (9,'Falta Reglamentaria');");
			db.execSQL("INSERT INTO Categoria values (10,'Todos');");	
			db.execSQL("INSERT INTO Infraccion values (1, 5000, 'Conducir en estado de embriaguez extrema: concentraci�n superior a 2 gramos de alcohol por litro de sangre. Vi�eta 1. Arto 26.',1);");  db.execSQL("INSERT INTO Infraccion values  (2, 4000, 'Conducir en estado de embriaguez: concentraci�n de m�s de 1 gramo hasta 2 gramos de alcohol por litro de sangre. Vi�eta 2. Arto 26.',1);");  db.execSQL("INSERT INTO Infraccion values  (3, 4000, 'Conducir bajo efectos de estupefacientes, psicotr�picos, estimulantes y sustancias controladas. Vi�eta 3. Arto 26.',1);");  db.execSQL("INSERT INTO Infraccion values  (4, 3000, 'Conducir de forma temeraria. Vi�eta 4. Arto 26.',2);");  db.execSQL("INSERT INTO Infraccion values  (5, 2500, 'Provocar accidente y darse a la fuga. Vi�eta 5. Arto 26.',3);");  db.execSQL("INSERT INTO Infraccion values  (6, 2500, 'Conducir a velocidad mayor que la que se exprese en la se�alizaci�n de tr�nsito o al est�ndar establecido. Vi�eta 6. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (7, 1000, 'Estacionar en carretera, trailers, rastras y contenedores sin tri�ngulos reflectivos u otras se�ales lum�nicas adecuadas para la prevenci�n de accidentes. Vi�eta 7. Arto 26.',4);");  db.execSQL("INSERT INTO Infraccion values  (8,1000, 'Giros indebidos en U y Zigzag. Vi�eta 8. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (9,1000,'Usar placas y/o circulaci�n de otro veh�culo. Vi�eta 9. Arto 26.',8);");  db.execSQL("INSERT INTO Infraccion values  (10,800,'Invasi�n de carril. Vi�eta 10. Arto 26.',2);");  db.execSQL("INSERT INTO Infraccion values  (11,500,'Trasladar mercader�a o carga a granel sin la protecci�n total de carpas o lonas. Vi�eta 11. Arto 26.',4);");  db.execSQL("INSERT INTO Infraccion values  (12,1000,'Participar en competencias ilegales de automotores. Vi�eta 12. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (13,500,'Conducir sin tener licencia de conducir. Vi�eta 13. Arto 26.',6);");  db.execSQL("INSERT INTO Infraccion values  (14,650,'No respetar la preferencia peatonal en las intersecciones o los cruces de colegios. Vi�eta 14. Arto 26.',1);");  db.execSQL("INSERT INTO Infraccion values  (15,500,'Exceso de pasajeros o de carga. Vi�eta 15. Arto 26.',6);");  db.execSQL("INSERT INTO Infraccion values  (16,500,'Aventajar en pendientes, curvas o puentes. Vi�eta 16. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (17,500, 'Conducir con las luces apagadas despu�s de la hora indicada, o durante el d�a cuando haya condiciones ambientales de lluvia, neblina o tolvanera. Vi�eta 17. Arto 26.',7);");  db.execSQL("INSERT INTO Infraccion values  (18,500,'Adelantar en l�nea continua amarilla. Vi�eta 18. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (19,500,'Conducir contra la v�a. Vi�eta 19. Arto 26.',5);");  db.execSQL("INSERT INTO Infraccion values  (20,500,'Obstrucci�n de la libre circulaci�n vehicular. Vi�eta 20. Arto 26.',7);");  db.execSQL("INSERT INTO Infraccion values  (21,500,'El conductor de motocicleta y acompa�ante que circulen sin portar debidamente el casco. Vi�eta 21. Arto 26.',7);");  db.execSQL("INSERT INTO Infraccion values  (22,350,'El conductor y acompa�antes de un veh�culo automotor, que no utilice el cintur�n de seguridad. Vi�eta 22. Arto 26.',7);");  db.execSQL("INSERT INTO Infraccion values  (23,350,'Desatender se�ales de emergencia, lum�nicas, sonoras de ambulancias, polic�a o bomberos. Vi�eta 23. Arto 26.',7);");  db.execSQL("INSERT INTO Infraccion values  (24,250,'Conducir utilizando manualmente tel�fonos m�viles, o cualquier otro aparato de distracci�n en el manejo. Vi�eta 24. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (25,500,'No reportar los cambios de las caracter�sticas f�sicas del veh�culo. Vi�eta 25. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (26,650,'Conducir con las puertas abiertas, transporte colectivo y de carga. Vi�eta 26. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (27,350,'Conducir carga sin la debida se�alizaci�n visible o reflectiva apropiada. Vi�eta 27. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (28,350,'Estacionarse en la v�a p�blica, en caso de emergencia, sin tri�ngulos reflectivos u otras se�ales lum�nicas adecuadas para la prevenci�n de accidentes. Vi�eta 28. Arto 26',4);");  db.execSQL("INSERT INTO Infraccion values  (29,350,'Transportar ni�os menores de siete a�os en el asiento delantero o en asientos posteriores de veh�culos sin cintur�n de seguridad o sistema de protecci�n o retenci�n infantil. Vi�eta 29. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (30,350,'Desatender se�ales de tr�nsito, verticales u horizontales, siempre que est�n visibles. Vi�eta 23. Arto 30',3);");  db.execSQL("INSERT INTO Infraccion values  (31,200,'Conducir motocicletas con ni�os menores de 8 a�os. Vi�eta 31. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (32,700,'Conducir cuadraciclos en ciudades y �reas no autorizadas por la Polic�a Nacional. Vi�eta 32. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (33,500,'Conducir veh�culos que provocan exceso de humo. Vi�eta 33. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (34,1000,'Conducir en estado de embriaguez ligera: Concentraci�n superior a 0.5 gramos hasta 1 gramo de alcohol por litro de sangre. Vi�eta 34. Arto 26',1);");  db.execSQL("INSERT INTO Infraccion values  (35,250,'Conducir cuadraciclos o triciclos sin utilizar debidamente el casco t�cnicamente adecuado. Vi�eta 35. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (36,250,'Conducir de retroceso en la v�a p�blica. Vi�eta 36. Arto 26',2);");  db.execSQL("INSERT INTO Infraccion values  (37,250,'Aventajar por la derecha en v�as de un solo carril. Vi�eta 37. Arto 26',2);");  db.execSQL("INSERT INTO Infraccion values  (38,250,'Subir pasajeros fuera de la bah�a o lugares no establecidos como paradas. Vi�eta 38. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (39,250,'Bajar o subir pasajeros por el lado izquierdo en la v�a p�blica. Vi�eta 39. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (40,250,'Realizar se�ales equivocadas sobre sus maniobras al conducir. Vi�eta 40. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (41,250,'Conducir veh�culo en mal estado mec�nico. Vi�eta 41. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (42,450,'Provocar ruidos escandalosos y perturbadores del medio ambiente. Vi�eta 42. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (43,250,'Circular con los veh�culos sobre bulevares, aceras o andenes. vi�eta 43. Arto 26',2);");  db.execSQL("INSERT INTO Infraccion values  (44,250,'No portar tri�ngulos fluorescentes o extinguidor. Vi�eta 45. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (45,160,'No guardar la distancia entre uno y otro veh�culo. Vi�eta 46. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (46,160,'Estacionarse: a) Sobre aceras y andenes. b) Frente a hidrantes. c) Frente a garajes. d) En las entradas de hospitales y cl�nicas. e) En los estacionamientos habilitados para personas con discapacidad, accesos o rampas para discapacitados. f) En paradas de buses, particulares o transporte selectivo. g) En rotondas. Vi�eta 47. Arto 26',4);");  db.execSQL("INSERT INTO Infraccion values  (47,320,'Tirar basura o desechos en la v�a p�blica desde veh�culos automotores de uso p�blico o privado. Vi�eta 48. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (48,320,'Conducir sin portar placas o licencia de circulaci�n. Vi�eta 49. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (49,320,'Conducir con licencia en categor�as diferentes a la autorizada. Vi�eta 50. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (50,320,'Transporte urbano colectivo, no detenerse a subir o bajar pasajeros en las paradas definidas por la autoridad correspondiente. Vi�eta 51. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (51,320,'Circular con placas no visibles, en mal estado o no autorizadas. Vi�eta 52. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (52,320,'Conducir con calcoman�a de revisado sin vigencia. Vi�eta 53. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (53,320,'Prestar servicio de transporte p�blico sin la debida autorizaci�n. Vi�eta 54. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (54,320,'Conducir automotores con el certificado o calcoman�a de emisi�n de gases o el certificado de inspecci�n mec�nica sin vigencia. Vi�eta 55. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values (55,250,'Conducir con la licencia vencida. Vi�eta 56. Arto 26',8);");  db.execSQL("INSERT INTO Infraccion values  (56,160,'Conducir transporte colectivo fuera de la ruta o servicio no autorizado. Vi�eta 57. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (57,160,'Conducir sin portar licencia. Vi�eta 58. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (58,160,'Circular sin loderas en las llantas traseras de veh�culos de carga o pasajeros. Vi�eta 59. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (59,160,'Circular sin espejos retrovisor interno o lateral. Vi�eta 60. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (60,200,'Obstruir la visibilidad en los vidrios del veh�culo utilizando polarizado no autorizado. Vi�eta 61. Arto 26',9);");  db.execSQL("INSERT INTO Infraccion values  (61,100,'Circular en bicicletas o medios de transporte de tracci�n animal sin se�ales lum�nicas visibles. Vi�eta 62. Arto 26',7);");  db.execSQL("INSERT INTO Infraccion values  (62,100,'Circular sin la calcoman�a del pago de impuesto de rodamiento. Vi�eta 63. Arto 26',9);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + CATEGORIA);
			db.execSQL("DROP TABLE IF EXISTS " + INFRACCION);
			onCreate(db);
			
		}
		
	}