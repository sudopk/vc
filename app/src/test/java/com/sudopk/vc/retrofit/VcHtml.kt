package com.sudopk.vc.retrofit

const val VC_HTML: String = """
  
<head>
<style>
	html { 
	  background: url(/dark.jpg) no-repeat center center fixed; 
	  -webkit-background-size: cover;
	  -moz-background-size: cover;
	  -o-background-size: cover;
	  background-size: cover;
	}
	table {
	    background: #E8E8E8;
	    width: 95%;
	}
	table#t01 {
	    width: 10%;
	    background-color: #333333;
	    color: ffffff;
	}
	a {
		color: ffffff;
		text-decoration: none;
	}
	h1 {
	color: 999999;
	}
</style>

</head>

<body>
<center><img src=/vcal.png></center>
<title>Vaisnava Calendar</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<center>
<table border=0 id="t01"><tr><td valign=top>
	<form>
	<select onChange="idx = this.selectedIndex; if (idx>0) top.parent.location=this.options[this.selectedIndex].value; this.selectedIndex=0;">
		<OPTION>MENU</OPTION>
		<OPTION VALUE=/>Index</OPTION>
	</select>
	</form>
</td><td valign=top>
	<form>
	<select onChange="idx = this.selectedIndex; if (idx>0) top.parent.location=this.options[this.selectedIndex].value; this.selectedIndex=0;">
		<OPTION>SELECT CITY</OPTION>
		<OPTION>ARGENTINA</OPTION>
		<OPTION VALUE=/4/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bhaia</OPTION><OPTION VALUE=/5/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buenos Aires</OPTION><OPTION VALUE=/6/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Córdoba</OPTION><OPTION VALUE=/7/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mar del Plata</OPTION><OPTION VALUE=/8/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mendoza</OPTION><OPTION VALUE=/9/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Neuquén</OPTION><OPTION VALUE=/10/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rio Ceballos</OPTION><OPTION VALUE=/11/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rosario</OPTION><OPTION VALUE=/12/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;San Juan</OPTION><OPTION VALUE=/504/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;San Luis</OPTION>	<OPTION>ARMENIA</OPTION>
	<OPTION VALUE=/3/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Yerevan</OPTION>	<OPTION>AUSTRALIA</OPTION>
	<OPTION VALUE=/13/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Adelaide</OPTION><OPTION VALUE=/14/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bambra - Victoria</OPTION><OPTION VALUE=/15/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brisbane</OPTION><OPTION VALUE=/16/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cairns</OPTION><OPTION VALUE=/17/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Canberra</OPTION><OPTION VALUE=/18/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cessnocknsw</OPTION><OPTION VALUE=/493/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Darwin</OPTION><OPTION VALUE=/19/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lismore</OPTION><OPTION VALUE=/20/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Melbourne</OPTION><OPTION VALUE=/21/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Murwillumbah</OPTION><OPTION VALUE=/22/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Perth</OPTION><OPTION VALUE=/23/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sydney</OPTION><OPTION VALUE=/24/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Winchelsea</OPTION>	<OPTION>AUSTRIA</OPTION>
	<OPTION VALUE=/25/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Graz</OPTION><OPTION VALUE=/26/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Klagenfurt</OPTION><OPTION VALUE=/27/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salzburg</OPTION><OPTION VALUE=/28/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;St Aegyd</OPTION><OPTION VALUE=/29/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vienna</OPTION>	<OPTION>AZERBAIJAN</OPTION>
	<OPTION VALUE=/30/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Baku</OPTION>	<OPTION>BAHRAIN</OPTION>
	<OPTION VALUE=/31/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Manama</OPTION>	<OPTION>BANGLADESH</OPTION>
	<OPTION VALUE=/32/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cittagong</OPTION><OPTION VALUE=/33/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dhaka</OPTION><OPTION VALUE=/34/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jessore</OPTION>	<OPTION>BARBADOS</OPTION>
	<OPTION VALUE=/35/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Barbados</OPTION>	<OPTION>BELARUS</OPTION>
	<OPTION VALUE=/36/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Minsk</OPTION>	<OPTION>BELGIUM</OPTION>
	<OPTION VALUE=/37/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Antwerp</OPTION><OPTION VALUE=/38/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brussels (Bruxelles)</OPTION><OPTION VALUE=/39/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Durbuy</OPTION><OPTION VALUE=/40/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Liege</OPTION>	<OPTION>BOLIVIA</OPTION>
	<OPTION VALUE=/41/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cochabamba</OPTION><OPTION VALUE=/42/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;La Paz</OPTION><OPTION VALUE=/43/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Santa Cruz</OPTION>	<OPTION>BOSNIA</OPTION>
	<OPTION VALUE=/44/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sarajevo</OPTION>	<OPTION>BOTSWANA</OPTION>
	<OPTION VALUE=/478/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gaborone</OPTION>	<OPTION>BRAZIL</OPTION>
	<OPTION VALUE=/481/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Areado</OPTION><OPTION VALUE=/45/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Belem</OPTION><OPTION VALUE=/46/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Belo Horizonte</OPTION><OPTION VALUE=/541/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Blumenau</OPTION><OPTION VALUE=/47/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brasilia</OPTION><OPTION VALUE=/48/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Campos</OPTION><OPTION VALUE=/49/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Caruaru</OPTION><OPTION VALUE=/50/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Curitiba</OPTION><OPTION VALUE=/51/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Florianopolis</OPTION><OPTION VALUE=/52/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fortaleza</OPTION><OPTION VALUE=/53/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Goiania</OPTION><OPTION VALUE=/54/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guarulhos</OPTION><OPTION VALUE=/56/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Juiz de Foa</OPTION><OPTION VALUE=/57/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jundia</OPTION><OPTION VALUE=/58/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lambari</OPTION><OPTION VALUE=/59/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Manaus</OPTION><OPTION VALUE=/495/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nova Gokula</OPTION><OPTION VALUE=/60/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Petropolis</OPTION><OPTION VALUE=/61/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porto Alegre</OPTION><OPTION VALUE=/62/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Recife</OPTION><OPTION VALUE=/63/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ribeirao Preto</OPTION><OPTION VALUE=/64/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rio de Janeiro</OPTION><OPTION VALUE=/65/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salvador</OPTION><OPTION VALUE=/66/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Santos</OPTION><OPTION VALUE=/67/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sao Carlos</OPTION><OPTION VALUE=/55/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sao Jose do Rio Preto</OPTION><OPTION VALUE=/68/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sao Paulo</OPTION><OPTION VALUE=/511/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Suzano</OPTION><OPTION VALUE=/69/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Taubate</OPTION><OPTION VALUE=/70/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ubatuba</OPTION><OPTION VALUE=/71/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vitoria</OPTION>	<OPTION>BULGARIA</OPTION>
	<OPTION VALUE=/72/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plovdiv</OPTION><OPTION VALUE=/73/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sofia</OPTION>	<OPTION>CAMEROON</OPTION>
	<OPTION VALUE=/74/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Buea</OPTION>	<OPTION>CANADA</OPTION>
	<OPTION VALUE=/75/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AL - Calgary</OPTION><OPTION VALUE=/76/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AL - Edmonton</OPTION><OPTION VALUE=/77/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BC - Ashcroft</OPTION><OPTION VALUE=/78/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BC - Vancouver</OPTION><OPTION VALUE=/81/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NF - Placentia</OPTION><OPTION VALUE=/79/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ON - Ottawa</OPTION><OPTION VALUE=/80/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ON - Toronto</OPTION><OPTION VALUE=/83/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QC - Montreal</OPTION><OPTION VALUE=/82/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;QC - Quebec</OPTION><OPTION VALUE=/84/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SK - Regina</OPTION><OPTION VALUE=/85/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;VC - Victoria</OPTION>	<OPTION>CHILE</OPTION>
	<OPTION VALUE=/86/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Concepcion</OPTION><OPTION VALUE=/518/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pucon</OPTION><OPTION VALUE=/87/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Santiago</OPTION>	<OPTION>CHINA</OPTION>
	<OPTION VALUE=/88/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Beijing</OPTION><OPTION VALUE=/89/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hong Kong</OPTION><OPTION VALUE=/494/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shangai</OPTION>	<OPTION>COLOMBIA</OPTION>
	<OPTION VALUE=/457/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Barranquilla</OPTION><OPTION VALUE=/90/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bogota</OPTION><OPTION VALUE=/91/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cali</OPTION><OPTION VALUE=/1/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Los Puranas</OPTION><OPTION VALUE=/524/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Medellin</OPTION><OPTION VALUE=/92/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pereira</OPTION>	<OPTION>COOK ISLANDS</OPTION>
	<OPTION VALUE=/499/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rarotonga</OPTION>	<OPTION>COSTA RICA</OPTION>
	<OPTION VALUE=/93/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;San Jose</OPTION>	<OPTION>CROATIA</OPTION>
	<OPTION VALUE=/94/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Osijek</OPTION><OPTION VALUE=/95/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pula</OPTION><OPTION VALUE=/96/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rijeka</OPTION><OPTION VALUE=/97/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Split</OPTION><OPTION VALUE=/98/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Zagreb</OPTION>	<OPTION>CUBA</OPTION>
	<OPTION VALUE=/99/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;La Habana</OPTION>	<OPTION>CYPRUS</OPTION>
	<OPTION VALUE=/100/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cyprus</OPTION>	<OPTION>CZECH REPUBLIC</OPTION>
	<OPTION VALUE=/101/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prague</OPTION><OPTION VALUE=/102/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Zlin</OPTION>	<OPTION>DENMARK</OPTION>
	<OPTION VALUE=/103/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brorup</OPTION><OPTION VALUE=/104/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Copenhagen</OPTION>	<OPTION>DOMINICAN REPUBLIC</OPTION>
	<OPTION VALUE=/105/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Santo Domingo</OPTION>	<OPTION>ECUADOR</OPTION>
	<OPTION VALUE=/106/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cuenca</OPTION><OPTION VALUE=/107/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guayaquil</OPTION><OPTION VALUE=/108/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quito</OPTION>	<OPTION>EL SALVADOR</OPTION>
	<OPTION VALUE=/109/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;San Salvador</OPTION>	<OPTION>ESTONIA</OPTION>
	<OPTION VALUE=/110/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tallinn</OPTION>	<OPTION>FIJI</OPTION>
	<OPTION VALUE=/111/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Labasa</OPTION><OPTION VALUE=/112/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lautoka</OPTION><OPTION VALUE=/526/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sigatoga</OPTION><OPTION VALUE=/113/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Suva</OPTION>	<OPTION>FINLAND</OPTION>
	<OPTION VALUE=/114/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Helsinki</OPTION><OPTION VALUE=/115/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tampere</OPTION><OPTION VALUE=/116/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Turku</OPTION>	<OPTION>FRANCE</OPTION>
	<OPTION VALUE=/117/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Avignon</OPTION><OPTION VALUE=/118/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bordeaux</OPTION><OPTION VALUE=/119/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brest</OPTION><OPTION VALUE=/120/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chateauroux</OPTION><OPTION VALUE=/121/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dijon</OPTION><OPTION VALUE=/122/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dole</OPTION><OPTION VALUE=/123/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lille</OPTION><OPTION VALUE=/124/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Longwy</OPTION><OPTION VALUE=/125/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lyon</OPTION><OPTION VALUE=/126/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nice</OPTION><OPTION VALUE=/127/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Orange</OPTION><OPTION VALUE=/128/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paris</OPTION><OPTION VALUE=/129/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Poitiers</OPTION><OPTION VALUE=/130/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Toulous</OPTION><OPTION VALUE=/131/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Valencay</OPTION>	<OPTION>GEORGIA</OPTION>
	<OPTION VALUE=/132/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tbilisi</OPTION>	<OPTION>GERMANY</OPTION>
	<OPTION VALUE=/133/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Berlin</OPTION><OPTION VALUE=/134/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bremerhaven</OPTION><OPTION VALUE=/135/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dresden</OPTION><OPTION VALUE=/136/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Flensburg</OPTION><OPTION VALUE=/137/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Frankfurt</OPTION><OPTION VALUE=/139/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hamburg</OPTION><OPTION VALUE=/140/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hannover</OPTION><OPTION VALUE=/141/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Heidelberg</OPTION><OPTION VALUE=/142/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Heilbronn</OPTION><OPTION VALUE=/143/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Karlsruhe</OPTION><OPTION VALUE=/144/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kiel</OPTION><OPTION VALUE=/145/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Koblenz</OPTION><OPTION VALUE=/146/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Koln (Cologne)</OPTION><OPTION VALUE=/147/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leipzig</OPTION><OPTION VALUE=/148/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Marburg</OPTION><OPTION VALUE=/149/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Munchen (Munich)</OPTION><OPTION VALUE=/150/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nurnberg (Nuremberg)</OPTION><OPTION VALUE=/151/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paderborn</OPTION><OPTION VALUE=/152/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Passau</OPTION><OPTION VALUE=/153/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Saarbrucken</OPTION><OPTION VALUE=/154/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salzwedel</OPTION><OPTION VALUE=/155/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Schwerin</OPTION><OPTION VALUE=/466/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Simhachalam</OPTION><OPTION VALUE=/156/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stuttgart</OPTION><OPTION VALUE=/157/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Trier</OPTION><OPTION VALUE=/158/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ulm</OPTION><OPTION VALUE=/482/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ummern</OPTION><OPTION VALUE=/159/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Weimar</OPTION><OPTION VALUE=/160/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wiesbaden</OPTION>	<OPTION>GHANA</OPTION>
	<OPTION VALUE=/161/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Accra</OPTION><OPTION VALUE=/162/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nkawkaw</OPTION><OPTION VALUE=/163/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Takoradi</OPTION>	<OPTION>GRECE</OPTION>
	<OPTION VALUE=/164/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Athens</OPTION>	<OPTION>GUATEMALA</OPTION>
	<OPTION VALUE=/165/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guatemala</OPTION>	<OPTION>GUYANA</OPTION>
	<OPTION VALUE=/166/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Berbice</OPTION><OPTION VALUE=/167/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Essequibo Coast</OPTION><OPTION VALUE=/168/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Georgetown</OPTION>	<OPTION>HONDURAS</OPTION>
	<OPTION VALUE=/169/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tegucigalpa</OPTION>	<OPTION>HUNGARY</OPTION>
	<OPTION VALUE=/170/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Budapest</OPTION><OPTION VALUE=/171/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Debrecen</OPTION><OPTION VALUE=/172/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kaposvar</OPTION><OPTION VALUE=/173/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Szolnok</OPTION>	<OPTION>ICELAND</OPTION>
	<OPTION VALUE=/174/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Reykjavik</OPTION>	<OPTION>INDIA</OPTION>
	<OPTION VALUE=/530/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AP - Giridhari Kunj</OPTION><OPTION VALUE=/175/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AP - Guntur</OPTION><OPTION VALUE=/176/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AP - Hyderabad</OPTION><OPTION VALUE=/177/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AP - Secunderabad</OPTION><OPTION VALUE=/178/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AP - Tirupati</OPTION><OPTION VALUE=/179/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AS - Guwahati</OPTION><OPTION VALUE=/180/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AS - Silchar</OPTION><OPTION VALUE=/181/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;BI - Patna</OPTION><OPTION VALUE=/182/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CH - Chandigarh</OPTION><OPTION VALUE=/183/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Ahmedabad</OPTION><OPTION VALUE=/473/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Anand</OPTION><OPTION VALUE=/535/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Bhavnagar</OPTION><OPTION VALUE=/184/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Dwaraka</OPTION><OPTION VALUE=/185/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Surat</OPTION><OPTION VALUE=/186/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Vadodara (Baroda)</OPTION><OPTION VALUE=/475/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GU - Vallabh Vidyanagar</OPTION><OPTION VALUE=/497/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HY - Faridabad</OPTION><OPTION VALUE=/187/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;JK - Udhampur</OPTION><OPTION VALUE=/188/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KA - Bangalore</OPTION><OPTION VALUE=/189/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KA - Belgaum</OPTION><OPTION VALUE=/190/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KA - Mangalore</OPTION><OPTION VALUE=/517/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KE - Kozhikode</OPTION><OPTION VALUE=/191/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KE - Thiruvananthapuram</OPTION><OPTION VALUE=/192/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;KE - Trivandrum</OPTION><OPTION VALUE=/198/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MA - Imphal</OPTION><OPTION VALUE=/199/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MA - Moirang</OPTION><OPTION VALUE=/467/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MP - Ujjain</OPTION><OPTION VALUE=/193/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MR - Aurangabad</OPTION><OPTION VALUE=/194/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MR - Mumbai (Bombay)</OPTION><OPTION VALUE=/195/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MR - Nagpur</OPTION><OPTION VALUE=/196/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MR - Pandharpur</OPTION><OPTION VALUE=/197/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MR - Pune</OPTION><OPTION VALUE=/200/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ND - New Delhi</OPTION><OPTION VALUE=/201/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OR - Bhubaneswar</OPTION><OPTION VALUE=/202/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OR - Puri</OPTION><OPTION VALUE=/505/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OR - Rourkela</OPTION><OPTION VALUE=/480/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PU - Amristar</OPTION><OPTION VALUE=/472/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PU - Jalandhar</OPTION><OPTION VALUE=/471/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PU - Ludiana</OPTION><OPTION VALUE=/203/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;RA - Jaipur</OPTION><OPTION VALUE=/205/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TN - Chennai (Madras)</OPTION><OPTION VALUE=/204/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TN - Coimbatore</OPTION><OPTION VALUE=/206/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TN - Srirangam</OPTION><OPTION VALUE=/207/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TR - Agartala</OPTION><OPTION VALUE=/208/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Allahabad</OPTION><OPTION VALUE=/534/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Ghaziabad</OPTION><OPTION VALUE=/209/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Hardwar</OPTION><OPTION VALUE=/210/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Lucknow</OPTION><OPTION VALUE=/211/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Mathura</OPTION><OPTION VALUE=/509/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Meerut</OPTION><OPTION VALUE=/212/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UP - Vrindavan</OPTION><OPTION VALUE=/213/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WB - Calcutta</OPTION><OPTION VALUE=/214/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WB - Mayapur</OPTION><OPTION VALUE=/529/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WB - Murishidabad</OPTION><OPTION VALUE=/215/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WB - Navadwip</OPTION><OPTION VALUE=/216/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WB - Siliguri</OPTION>	<OPTION>INDONESIA</OPTION>
	<OPTION VALUE=/217/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bali</OPTION><OPTION VALUE=/218/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bogor</OPTION><OPTION VALUE=/219/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Denpasar</OPTION><OPTION VALUE=/220/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jakarta</OPTION><OPTION VALUE=/453/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jogjakarta</OPTION>	<OPTION>IRAN</OPTION>
	<OPTION VALUE=/221/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Teheran</OPTION>	<OPTION>ISRAEL</OPTION>
	<OPTION VALUE=/222/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Telaviv</OPTION>	<OPTION>ITALY</OPTION>
	<OPTION VALUE=/223/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bergamo</OPTION><OPTION VALUE=/224/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bologna</OPTION><OPTION VALUE=/225/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Catania</OPTION><OPTION VALUE=/226/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Firenze (Florence)</OPTION><OPTION VALUE=/227/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Milan</OPTION><OPTION VALUE=/228/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Napoli (Naples)</OPTION><OPTION VALUE=/229/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Padua</OPTION><OPTION VALUE=/537/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Perugia</OPTION><OPTION VALUE=/230/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pisa</OPTION><OPTION VALUE=/539/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rimini</OPTION><OPTION VALUE=/231/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Roma</OPTION><OPTION VALUE=/538/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Terni</OPTION><OPTION VALUE=/528/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Torino</OPTION><OPTION VALUE=/488/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Verona</OPTION><OPTION VALUE=/232/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vicenza</OPTION>	<OPTION>IVORY COAST</OPTION>
	<OPTION VALUE=/233/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Abidjan</OPTION>	<OPTION>JAPAN</OPTION>
	<OPTION VALUE=/533/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fukuoka</OPTION><OPTION VALUE=/234/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Okinawa</OPTION><OPTION VALUE=/235/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sapporo</OPTION><OPTION VALUE=/236/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tokyo</OPTION>	<OPTION>KAZAKHSTAN</OPTION>
	<OPTION VALUE=/237/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Alma-ata</OPTION>	<OPTION>KENYA</OPTION>
	<OPTION VALUE=/238/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kisumu</OPTION><OPTION VALUE=/239/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mombasa</OPTION><OPTION VALUE=/240/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nairobi</OPTION>	<OPTION>KUWAIT</OPTION>
	<OPTION VALUE=/474/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kuwait</OPTION>	<OPTION>LATVIA</OPTION>
	<OPTION VALUE=/241/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Riga</OPTION>	<OPTION>LITHUANIA</OPTION>
	<OPTION VALUE=/242/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Alytus</OPTION><OPTION VALUE=/243/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Druskininkai</OPTION><OPTION VALUE=/244/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kaunas</OPTION><OPTION VALUE=/245/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Klaipeda</OPTION><OPTION VALUE=/246/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mazheikiai</OPTION><OPTION VALUE=/247/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Panevezhys</OPTION><OPTION VALUE=/248/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shyaulyai</OPTION><OPTION VALUE=/249/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Utena</OPTION><OPTION VALUE=/250/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vilnius</OPTION>	<OPTION>MACEDONIA</OPTION>
	<OPTION VALUE=/506/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Skopje</OPTION>	<OPTION>MALAYSIA</OPTION>
	<OPTION VALUE=/251/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bukit Mertajam</OPTION><OPTION VALUE=/252/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ipoh</OPTION><OPTION VALUE=/253/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kuala Lumpur</OPTION><OPTION VALUE=/254/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Perak</OPTION>	<OPTION>MAURITIUS</OPTION>
	<OPTION VALUE=/255/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mauritius</OPTION>	<OPTION>MEXICO</OPTION>
	<OPTION VALUE=/256/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancun</OPTION><OPTION VALUE=/523/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Colima</OPTION><OPTION VALUE=/257/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Culiacan</OPTION><OPTION VALUE=/507/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Durango</OPTION><OPTION VALUE=/258/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guadalajara</OPTION><OPTION VALUE=/532/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;La Paz</OPTION><OPTION VALUE=/259/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leon</OPTION><OPTION VALUE=/260/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Loreto</OPTION><OPTION VALUE=/261/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mexico City</OPTION><OPTION VALUE=/262/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Monterrey</OPTION><OPTION VALUE=/263/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Morelia</OPTION><OPTION VALUE=/483/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pachuca</OPTION><OPTION VALUE=/264/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Saltillo</OPTION><OPTION VALUE=/484/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;San Luis Potosi</OPTION><OPTION VALUE=/265/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tijuana</OPTION><OPTION VALUE=/500/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Torreon</OPTION><OPTION VALUE=/266/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tulancingo</OPTION><OPTION VALUE=/267/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Veracruz</OPTION><OPTION VALUE=/268/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Villahermosa</OPTION>	<OPTION>NEPAL</OPTION>
	<OPTION VALUE=/269/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kathmandu</OPTION>	<OPTION>NETHERLANDS</OPTION>
	<OPTION VALUE=/270/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Amsterdam</OPTION><OPTION VALUE=/460/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Den Haag</OPTION><OPTION VALUE=/271/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Utrecht</OPTION>	<OPTION>NEW ZEALAND</OPTION>
	<OPTION VALUE=/272/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Auckland</OPTION><OPTION VALUE=/273/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Christchurch</OPTION><OPTION VALUE=/508/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Hamilton</OPTION><OPTION VALUE=/274/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wellington</OPTION>	<OPTION>NICARAGUA</OPTION>
	<OPTION VALUE=/275/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chinandega</OPTION><OPTION VALUE=/276/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Managua</OPTION>	<OPTION>NIGERIA</OPTION>
	<OPTION VALUE=/277/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Abeokuta</OPTION><OPTION VALUE=/278/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Benin City</OPTION><OPTION VALUE=/279/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Enugu</OPTION><OPTION VALUE=/280/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ibadan</OPTION><OPTION VALUE=/281/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kaduna</OPTION><OPTION VALUE=/282/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lagos</OPTION><OPTION VALUE=/283/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Porth Arcourt</OPTION><OPTION VALUE=/284/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Warri</OPTION>	<OPTION>NORTHERN IRELAND</OPTION>
	<OPTION VALUE=/285/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Belfast</OPTION><OPTION VALUE=/286/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Derrylin</OPTION>	<OPTION>NORWAY</OPTION>
	<OPTION VALUE=/287/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bergen</OPTION><OPTION VALUE=/288/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Oslo</OPTION>	<OPTION>PAKISTAN</OPTION>
	<OPTION VALUE=/492/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Karachi</OPTION>	<OPTION>PANAMA</OPTION>
	<OPTION VALUE=/289/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Panam</OPTION>	<OPTION>PAPUA NEW GUINEA</OPTION>
	<OPTION VALUE=/290/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Port Morseby</OPTION>	<OPTION>PARAGUAY</OPTION>
	<OPTION VALUE=/291/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Asunci</OPTION>	<OPTION>PERU</OPTION>
	<OPTION VALUE=/292/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Arequipa</OPTION><OPTION VALUE=/498/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Chiclayo</OPTION><OPTION VALUE=/293/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cuzco</OPTION><OPTION VALUE=/513/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Huancayo</OPTION><OPTION VALUE=/514/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Huanuco</OPTION><OPTION VALUE=/476/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ica</OPTION><OPTION VALUE=/294/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iquitos</OPTION><OPTION VALUE=/295/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lima</OPTION><OPTION VALUE=/459/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Neuqu</OPTION><OPTION VALUE=/296/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Puno</OPTION><OPTION VALUE=/297/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salcabamba</OPTION><OPTION VALUE=/515/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Satipo</OPTION><OPTION VALUE=/298/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tarapoto</OPTION><OPTION VALUE=/516/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Trujillo</OPTION>	<OPTION>PHILIPPINES</OPTION>
	<OPTION VALUE=/299/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cagayan</OPTION><OPTION VALUE=/300/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cebu</OPTION><OPTION VALUE=/301/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Iloilo</OPTION><OPTION VALUE=/302/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Manila</OPTION>	<OPTION>POLAND</OPTION>
	<OPTION VALUE=/303/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gdansk</OPTION><OPTION VALUE=/304/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gorzow</OPTION><OPTION VALUE=/305/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Warsaw</OPTION><OPTION VALUE=/306/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wroclaw</OPTION>	<OPTION>PORTUGAL</OPTION>
	<OPTION VALUE=/307/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lisboa</OPTION><OPTION VALUE=/308/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Oporto</OPTION>	<OPTION>RUMANIA</OPTION>
	<OPTION VALUE=/309/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bucharest</OPTION><OPTION VALUE=/310/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Timisoara</OPTION>	<OPTION>RUSSIA</OPTION>
	<OPTION VALUE=/311/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ekaterinburg</OPTION><OPTION VALUE=/312/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Krasnoyarsk</OPTION><OPTION VALUE=/313/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Moscow</OPTION><OPTION VALUE=/314/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Novosibirsk</OPTION><OPTION VALUE=/315/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;St Petersburg</OPTION><OPTION VALUE=/316/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vladikavkaz</OPTION><OPTION VALUE=/317/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vladivostok</OPTION>	<OPTION>SAUDI ARABIA</OPTION>
	<OPTION VALUE=/522/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Damman</OPTION><OPTION VALUE=/521/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jeddah</OPTION><OPTION VALUE=/520/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Riyadh</OPTION>	<OPTION>SEICHELLES</OPTION>
	<OPTION VALUE=/465/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Victoria</OPTION>	<OPTION>SENEGAL</OPTION>
	<OPTION VALUE=/540/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dakar</OPTION>	<OPTION>SERBIA</OPTION>
	<OPTION VALUE=/318/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Belgrade</OPTION><OPTION VALUE=/319/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sombor</OPTION>	<OPTION>SIERRA LEONE</OPTION>
	<OPTION VALUE=/320/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Freetown</OPTION>	<OPTION>SINGAPORE</OPTION>
	<OPTION VALUE=/321/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Singapore</OPTION>	<OPTION>SLOVAK REPUBLIC</OPTION>
	<OPTION VALUE=/322/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bratislava</OPTION><OPTION VALUE=/479/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nova Ekacakra</OPTION><OPTION VALUE=/323/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Trnava</OPTION>	<OPTION>SLOVENIA</OPTION>
	<OPTION VALUE=/324/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ljubljana</OPTION>	<OPTION>SOUTH AFRICA</OPTION>
	<OPTION VALUE=/325/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cape Town</OPTION><OPTION VALUE=/326/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Durban</OPTION><OPTION VALUE=/327/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Johannesburg</OPTION><OPTION VALUE=/328/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Port Elizabeth</OPTION>	<OPTION>SOUTH COREA</OPTION>
	<OPTION VALUE=/519/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Seoul</OPTION>	<OPTION>SPAIN</OPTION>
	<OPTION VALUE=/329/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Barcelona</OPTION><OPTION VALUE=/330/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Brihuega</OPTION><OPTION VALUE=/331/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Galicia</OPTION><OPTION VALUE=/458/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guadalajara</OPTION><OPTION VALUE=/332/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Is. Canarias</OPTION><OPTION VALUE=/334/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Madrid</OPTION><OPTION VALUE=/335/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Málaga</OPTION><OPTION VALUE=/336/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Santa Cruz de Tenerife</OPTION><OPTION VALUE=/337/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Valencia</OPTION>	<OPTION>SRI LANKA</OPTION>
	<OPTION VALUE=/338/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Colombo</OPTION>	<OPTION>SURINAM</OPTION>
	<OPTION VALUE=/491/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Nieuw Nickerie</OPTION><OPTION VALUE=/339/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Paramaribo</OPTION>	<OPTION>SWEDEN</OPTION>
	<OPTION VALUE=/340/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Avesta</OPTION><OPTION VALUE=/341/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Gothenburg</OPTION><OPTION VALUE=/343/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Haparanda</OPTION><OPTION VALUE=/344/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Horby</OPTION><OPTION VALUE=/345/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Jonkoping</OPTION><OPTION VALUE=/346/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Karlstad</OPTION><OPTION VALUE=/347/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ludvika</OPTION><OPTION VALUE=/348/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lulea</OPTION><OPTION VALUE=/349/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lund</OPTION><OPTION VALUE=/350/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Malmö</OPTION><OPTION VALUE=/356/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Östersund</OPTION><OPTION VALUE=/351/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Stockholm</OPTION><OPTION VALUE=/352/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sundsvall</OPTION><OPTION VALUE=/353/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Umea</OPTION><OPTION VALUE=/354/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Uppsala</OPTION><OPTION VALUE=/355/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Visby</OPTION>	<OPTION>SWITZERLAND</OPTION>
	<OPTION VALUE=/357/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Basel</OPTION><OPTION VALUE=/358/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bern</OPTION><OPTION VALUE=/359/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dudingen</OPTION><OPTION VALUE=/360/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Geneva</OPTION><OPTION VALUE=/361/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lugano</OPTION><OPTION VALUE=/362/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Schaffhausen</OPTION><OPTION VALUE=/363/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Zürich</OPTION>	<OPTION>SYRIA</OPTION>
	<OPTION VALUE=/364/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Al Quneitrah</OPTION>	<OPTION>TAIWAN</OPTION>
	<OPTION VALUE=/365/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Taipei</OPTION>	<OPTION>THAILAND</OPTION>
	<OPTION VALUE=/366/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bangkok</OPTION>	<OPTION>TURKEY</OPTION>
	<OPTION VALUE=/454/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ankara</OPTION><OPTION VALUE=/455/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Istambul</OPTION><OPTION VALUE=/456/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Izhir</OPTION>	<OPTION>UGANDA</OPTION>
	<OPTION VALUE=/368/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kampala</OPTION>	<OPTION>UNITED KINGDOM</OPTION>
	<OPTION VALUE=/369/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Birmingham</OPTION><OPTION VALUE=/370/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Bristol</OPTION><OPTION VALUE=/371/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cardiff</OPTION><OPTION VALUE=/372/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cleethorpes</OPTION><OPTION VALUE=/373/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Coventry</OPTION><OPTION VALUE=/374/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dublin</OPTION><OPTION VALUE=/375/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Glasgow</OPTION><OPTION VALUE=/501/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Great Bricet</OPTION><OPTION VALUE=/376/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Leicester</OPTION><OPTION VALUE=/377/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Liverpool</OPTION><OPTION VALUE=/378/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;London</OPTION><OPTION VALUE=/379/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Manchester</OPTION><OPTION VALUE=/380/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New Castle</OPTION><OPTION VALUE=/381/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Plymouth</OPTION><OPTION VALUE=/382/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Romford</OPTION><OPTION VALUE=/383/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Wexford</OPTION><OPTION VALUE=/384/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Worcester</OPTION>	<OPTION>UKRAINE</OPTION>
	<OPTION VALUE=/385/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kiev</OPTION><OPTION VALUE=/386/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Odessa</OPTION>	<OPTION>UNITED ARAB EMIRATES</OPTION>
	<OPTION VALUE=/477/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Abu Dhabi</OPTION><OPTION VALUE=/469/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dubai</OPTION>	<OPTION>URUGUAY</OPTION>
	<OPTION VALUE=/387/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Montevideo</OPTION>	<OPTION>UNITED STATES</OPTION>
	<OPTION VALUE=/389/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AL - Juneau</OPTION><OPTION VALUE=/390/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AZ - Phoenix</OPTION><OPTION VALUE=/391/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;AZ - Tucson</OPTION><OPTION VALUE=/503/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA  - Oakland</OPTION><OPTION VALUE=/392/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Arcata</OPTION><OPTION VALUE=/393/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Berkeley</OPTION><OPTION VALUE=/394/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Los Angeles</OPTION><OPTION VALUE=/395/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Palo Alto</OPTION><OPTION VALUE=/527/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Sacramento</OPTION><OPTION VALUE=/396/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - San Diego</OPTION><OPTION VALUE=/397/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - San Francisco</OPTION><OPTION VALUE=/398/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - San Jose</OPTION><OPTION VALUE=/399/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - San Luis Obispo</OPTION><OPTION VALUE=/536/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CA - Walnut Creek</OPTION><OPTION VALUE=/400/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CO - Boulder</OPTION><OPTION VALUE=/401/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CO - Denver</OPTION><OPTION VALUE=/402/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CT - Hartford</OPTION><OPTION VALUE=/403/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DC - Washington</OPTION><OPTION VALUE=/404/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FL - Gainesville</OPTION><OPTION VALUE=/405/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FL - Key West</OPTION><OPTION VALUE=/406/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FL - Miami</OPTION><OPTION VALUE=/407/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FL - Tallahassee</OPTION><OPTION VALUE=/408/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;FL - Tampa</OPTION><OPTION VALUE=/409/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GA - Atlanta</OPTION><OPTION VALUE=/410/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HI - Hilo</OPTION><OPTION VALUE=/411/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;HI - Honolulu</OPTION><OPTION VALUE=/412/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ID - Boise</OPTION><OPTION VALUE=/413/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IL - Chicago</OPTION><OPTION VALUE=/502/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IN - Indianapolis</OPTION><OPTION VALUE=/414/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LA - New Orleans</OPTION><OPTION VALUE=/416/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MA - Boston</OPTION><OPTION VALUE=/415/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MD - Baltimore</OPTION><OPTION VALUE=/417/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MI - Detroit</OPTION><OPTION VALUE=/418/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MI - Lansing</OPTION><OPTION VALUE=/496/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MN - Mineapolis</OPTION><OPTION VALUE=/420/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MO - St Louis</OPTION><OPTION VALUE=/419/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;MS - Picayune</OPTION><OPTION VALUE=/424/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NC - Chapelhill</OPTION><OPTION VALUE=/425/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NC - Durham</OPTION><OPTION VALUE=/485/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NC - Hillsborough</OPTION><OPTION VALUE=/531/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NC - Sandy Ridge</OPTION><OPTION VALUE=/426/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NC - Winston-Salem</OPTION><OPTION VALUE=/421/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NJ - Morristown</OPTION><OPTION VALUE=/422/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NM - Alburquerque</OPTION><OPTION VALUE=/423/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NY - New York</OPTION><OPTION VALUE=/470/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NY - Syracuse</OPTION><OPTION VALUE=/427/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OH - Cleveland</OPTION><OPTION VALUE=/428/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OH - Columbus</OPTION><OPTION VALUE=/429/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OK - Oklahoma City</OPTION><OPTION VALUE=/431/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OR - Eugene</OPTION><OPTION VALUE=/430/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OR - Portland</OPTION><OPTION VALUE=/432/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PA - Gita-nagari Farm</OPTION><OPTION VALUE=/433/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PA - Harrisburg</OPTION><OPTION VALUE=/434/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PA - Philadelphia</OPTION><OPTION VALUE=/435/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PA - Pittsburgh</OPTION><OPTION VALUE=/525/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PA - Reading</OPTION><OPTION VALUE=/436/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PR - Puerto Rico</OPTION><OPTION VALUE=/437/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PR - San Juan</OPTION><OPTION VALUE=/438/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SC - Charleston</OPTION><OPTION VALUE=/388/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Territory - Virgin Islands</OPTION><OPTION VALUE=/439/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TX - Austin</OPTION><OPTION VALUE=/440/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TX - Dallas</OPTION><OPTION VALUE=/490/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TX - Harlingen</OPTION><OPTION VALUE=/441/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TX - Houston</OPTION><OPTION VALUE=/442/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;TX - Waco</OPTION><OPTION VALUE=/443/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UT - Provo</OPTION><OPTION VALUE=/444/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WS - Seattle</OPTION><OPTION VALUE=/445/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WS - Walla Walla</OPTION><OPTION VALUE=/446/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WV - Moundsville</OPTION><OPTION VALUE=/447/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;WV - New Vrindaban</OPTION>	<OPTION>UZBEKISTAN</OPTION>
	<OPTION VALUE=/448/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tashkent</OPTION>	<OPTION>VENEZUELA</OPTION>
	<OPTION VALUE=/449/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Caracas</OPTION>	<OPTION>ZAMBIA</OPTION>
	<OPTION VALUE=/450/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Kitwe-nkana</OPTION><OPTION VALUE=/451/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Lusaka</OPTION>	<OPTION>ZIMBABWE</OPTION>
	<OPTION VALUE=/452/2021/12/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Harare</OPTION>	</select>
	</form>
</td><td valign=top>
</td><td valign=top>
	<form>
	<select onChange="idx = this.selectedIndex; if (idx>0) top.parent.location=this.options[this.selectedIndex].value; this.selectedIndex=0;">
		<OPTION>OTHER SITES</OPTION>
		<OPTION VALUE=http://www.iskcon.com.mx>ISKCON Virtual Temple</OPTION>
		<OPTION VALUE=http://www.krishnawest.com>Krishna West</OPTION>
		<OPTION VALUE=http://www.bhaktivedantalibrary.com>Bhaktivedanta Library</OPTION>
		<OPTION VALUE=http://www.istagosthi.com>Virtual Istagosthi</OPTION>
	</select>
	</form>
</td><td valign=top>
	<iframe src='//www.facebook.com/plugins/like.php?href=https%3A%2F%2Fwww.facebook.com%2FVaisnavaCalendar&amp;width=250&amp;layout=button_count&amp;action=like&amp;show_faces=false&amp;share=false&amp;height=40&amp;appId=1374613962823729' scrolling='no' frameborder='0' style='border:none; overflow:hidden; height:40px;' allowTransparency='true'></iframe>
</td></tr><tr><td colspan=4 valign=bottom>
	<SCRIPT SRC="http://www.iskcon.com.mx/banner.js"></SCRIPT>
</td><td valign=bottom>
	<script type="text/javascript" src="https://vk.com/js/api/openapi.js?162"></script>
	<div id="vk_groups"></div>
	<script type="text/javascript">
		VK.Widgets.Group("vk_groups", {mode: 1, no_cover: 1, height: 200}, 185139045);
	</script>
</td></tr>
</table>
<h1><a href=../11><img src=/imagenes/previous.png title=Previous></a> December 2021  - CA - Palo Alto - USA <!--<a href=../><img src=/imagenes/next.png title=Next></a>--></h1>
<table border=1 width=100%>
	<tr><td width=14%>
		<center><b>Sunday
	</td><td width=14%>
		<center><b>Monday
	</td><td width=14%>
		<center><b>Tuesday
	</td><td width=14%>
		<center><b>Wednesday
	</td><td width=14%>
		<center><b>Thursday
	</td><td width=14%>
		<center><b>Friday
	</td><td width=14%>
		<center><b>Saturday
	</td></tr>
	<tr><td width=14%>
		<table border=0 width=100%>
		<tr><td width=60%>
			</td><td>
				<center><h1>
			</td></tr><tr><td colspan=2>
		</td></tr>
		</table>
	</td><td width=14%>
		<table border=0 width=100%>
		<tr><td width=60%>
			</td><td>
				<center><h1>
			</td></tr><tr><td colspan=2>
		</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
			</td><td>
				<center><h1>
			</td></tr><tr><td colspan=2>
		</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dvadasi			</td><td>
				<center><h1>1
			</td></tr><tr><td colspan=2>
			</td></tr><tr><td colspan=2 bgcolor=A9F5A9><center>Break fast 07:05 - 10:07 <br>(Daylight saving not considered)<br></td></tr><tr><td colspan=2><center>Sri Kaliya Krsnadasa <img src=/imagenes/dis.gif height=16>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Caturdasi			</td><td>
				<center><h1>2
			</td></tr><tr><td colspan=2>
			<center></td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Radhanath Svami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2><center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Amavasya			</td><td>
				<center><h1>3
			</td></tr><tr><td colspan=2>
			
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Pratipat			</td><td>
				<center><h1>4
			</td></tr><tr><td colspan=2>
			<center></td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Partha Sarathi Gosvami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2><center>
					</td></tr>
		</table>
	</td></tr>

	<tr><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dvitiya			</td><td>
				<center><h1>5
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Tritiya			</td><td>
				<center><h1>6
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Caturthi			</td><td>
				<center><h1>7
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Pancami			</td><td>
				<center><h1>8
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Saptami			</td><td>
				<center><h1>9
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Astami			</td><td>
				<center><h1>10
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Navami			</td><td>
				<center><h1>11
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td></tr>

	<tr><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dasami			</td><td>
				<center><h1>12
			</td></tr><tr><td colspan=2>
			<center>Advent of Srimad Bhagavad-gita</td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Krishna Ksetra Svami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2><center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dasami			</td><td>
				<center><h1>13
			</td></tr><tr><td colspan=2>
			<center>		</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Suddha Ekadasi			</td><td>
				<center><h1>14
			</td></tr><tr><td colspan=2>
			</td></tr><tr><td colspan=2 bgcolor=A9F5A9><center>Moksada Ekadasi</td></tr><tr><td colspan=2><center>Advent of Srimad Bhagavad-</td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Satsvarupa dasa Gosvami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2><center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dvadasi			</td><td>
				<center><h1>15
			</td></tr><tr><td colspan=2>
			</td></tr><tr><td colspan=2 bgcolor=A9F5A9><center>Break fast 07:16 - 10:28 <br>(Daylight saving not considered)<br></td></tr><tr><td colspan=2>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Trayodasi			</td><td>
				<center><h1>16
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Caturdasi			</td><td>
				<center><h1>17
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Purnima			</td><td>
				<center><h1>18
			</td></tr><tr><td colspan=2>
			<center>Katyayani vrata ends</td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Mahavisnu Gosvami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2><center>
					</td></tr>
		</table>
	</td></tr>

	<tr><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Pratipat			</td><td>
				<center><h1>19
			</td></tr><tr><td colspan=2>
			<center></td></tr><tr><td colspan=2 bgcolor=BDBDBD><center>Narayana Masa</td></tr><tr><td colspan=2>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dvitiya			</td><td>
				<center><h1>20
			</td></tr><tr><td colspan=2>
			<center>		</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Tritiya			</td><td>
				<center><h1>21
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Caturthi			</td><td>
				<center><h1>22
			</td></tr><tr><td colspan=2>
			<center></td></tr><tr><td colspan=2 bgcolor=F3E2A9><center>Srila Bhaktisiddhanta Sarasvati Thakura <img src=/imagenes/dis.gif height=16><br>(Fasting till noon)</td></tr><tr><td colspan=2>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Pancami			</td><td>
				<center><h1>23
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Sasti			</td><td>
				<center><h1>24
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Saptami			</td><td>
				<center><h1>25
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td></tr>

	<tr><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Astami			</td><td>
				<center><h1>26
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Navami			</td><td>
				<center><h1>27
			</td></tr><tr><td colspan=2>
			<center></td></tr><tr><td colspan=2 bgcolor=FAAC58><center>HH Niranjana Svami <img src=/imagenes/ap.gif height=16></td></tr><tr><td colspan=2>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Dasami			</td><td>
				<center><h1>28
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		<center>Suddha Ekadasi			</td><td>
				<center><h1>29
			</td></tr><tr><td colspan=2>
			</td></tr><tr><td colspan=2 bgcolor=A9F5A9><center>Saphala Ekadasi</td></tr><tr><td colspan=2><center>Sri Devananda Pandita <img src=/imagenes/dis.gif height=16>		</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
		
						</td><td>
				<center><h1>30
			</td></tr><tr><td colspan=2>
			<center>
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
					</td><td>
				<center><h1>31
			</td></tr><tr><td colspan=2>
			
					</td></tr>
		</table>
	</td><td width=14% valign=top>
		<table border=0 width=100%>
		<tr><td width=60%>
			</td><td>
				<center><h1>
			</td></tr><tr><td colspan=2>
		</td></tr>
		</table>
	</td></tr>


	</table>
<br><font size=1>209</font>
"""

