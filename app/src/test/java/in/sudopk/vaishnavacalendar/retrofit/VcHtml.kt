package com.sudopk.vc.retrofit

const val DAYS_IN_VC_HTML = 31

const val VC_HTML: String = """
<HTML>
<HEAD>
<TITLE>Vaisnava Calendar</TITLE>
<meta name='author' content='.'>
<meta name='keywords' content='.'>
<meta http-equiv='Content-Type' content='text/html;charset=iso-8859-1'>
<meta name='distribution' content='global'>
<meta name='resource-type' content='document'>
<meta name='robots' content='all'>
<link rel='stylesheet' href='style.css' type='text/css'>

<SCRIPT language=JavaScript>
/*
* DHTML Menu version 3.3
* written by Andy Woolley
* Copyright 2002 Andy Woolley. All Rights Reserved.
*
* Please feel free to use this code on your own website free of charge.
* You can also distribute and modify this source code as long as this
* Copyright notice remains intact and that you send me notice that you
* intend to use this code on your website.
*
* Limited support for this script is provided
* Commercial licence agreements are available on request for full support.
* You can send email to menu3@milonic.com
*/
</SCRIPT>

<script>
 function CheckCIIDSelect()
  {
   val=document.getElementById('CIID').value;
   if (val==0) return false;
   document.location='vcal.php?month=05&year=2017&lang=en&CIID='+val;
   return true;
  }

function CheckSelectHoliday()
 {
   val=document.getElementById('code').value;
   if (val==0) return false;
   window.location='search.php?month=05&year=2017&lang=en&CIID=413&code='+val;
   return true;

 }

</script>

<SCRIPT language=JavaScript src='../menues/scrolling_array2.js' type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript src='../menues/menu_array.js' type=text/javascript></SCRIPT>
<!--<SCRIPT language=JavaScript src='../menues/menu2_array.js' type=text/javascript></SCRIPT>-->
<SCRIPT language=JavaScript src='../menues/lineahalf_array.js' type=text/javascript></SCRIPT>
<SCRIPT language=JavaScript src='../menues/mmenu.js' type=text/javascript></SCRIPT>
<!--<SCRIPT LANGUAGE='JavaScript1.2' SRC='../menues/topmenu.js'></SCRIPT>-->

</HEAD>

<BODY topmargin=0 leftmargin=0 BGPROPERTIES='FIXED' TEXT=7E6B46 BGCOLOR=FFE2A9 LINK=7E6B46 VLINK=7E6B46>

<center>

<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH=100% BGCOLOR=000000>
<TR><TD WIDTH=100 rowspan=2 HEIGTH=62>
	<OBJECT classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 codebase=http://active.macromedia.com/flash2/cabs/swflash.cab#version=4,0,0,0 ID=logo WIDTH=100 HEIGHT=62><PARAM NAME=movie VALUE=http://www.iskcon.com.mx/java/logo.swf><PARAM NAME=quality VALUE=high><PARAM NAME=bgcolor VALUE=000000><EMBED src=http://www.iskcon.com.mx/java/logo.swf quality=high bgcolor=000000 WIDTH=100 HEIGHT=62 TYPE=application/x-shockwave-flash PLUGINSPAGE=http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash></EMBED></OBJECT>
</TD><TD VALIGN=TOP WIDTH=500 colspan=5>
	<FONT COLOR=000000>.
</TD></TR><tr><td valign=bottom>
	<center><font color=ffffff>
	<a href='print_cal.php?CIID=413&month=05&year=2017&lang=en'><img src=print.gif border=0 alt='Printable version'>
	<b>Printable version</b></a>
</td><td valign=bottom>
	<a href='javascript:;' onClick=window.open('/help_en.php','_blank','width=500,height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false>
	<img src=help.gif border=0 alt='Online Help'>
	<b>Online Help</b></a>
</td><td valign=bottom>
	<center>
	<a href='/facebook/?lang=en'><img src=/facebook.gif border=0 alt='Facebook'>
	<b>Facebook</b></a>
</td><td valign=bottom>
	<center><font color=ffffff>
	<a href='vcal.php?CIID=413&lang=en&month=04&year=2017'><img src=previous.gif border=0 alt='Prev Month'>
	<b>Prev Month</b></a>
</td><td valign=bottom>
	<center><font color=ffffff>
	<a href='vcal.php?CIID=413&lang=en&month=06&year=2017'><img src=next.gif border=0 alt='Next Month'>
	<b>Next Month</b></a>
</td><!--<td valign=bottom>
	<center><font color=ffffff>
	<a href='ics.php?CIID=413&month=05&year=2017&lang=en'><img src=ics.gif border=0 alt='For your PC or Mobile'>
	<b>LANG_MENU_ICS</b></a>
</td>--></tr>
</TABLE>


<TABLE BORDER=0 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>
<TR><td valign=bottom>
	<center>
	<img src=title_en.jpg><br>
	May 2017<br>Chicago, Illinois, USA (087W45 41N53, Time zone = -6.00)
</td><td valign=top>
        <center>
        <table border=0 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>
        <tr><td valign=bottom>
		<SCRIPT LANGUAGE='JavaScript'>
		<!--
		function nav2Handler(list){
		window.location.href = list.options[list.selectedIndex].value; }
		// -->
		</SCRIPT>
		<FORM name =  'nav2'>
		<SELECT NAME='site' SIZE=1 onChange ='nav2Handler(document.nav2.site)'>
		<OPTION VALUE='servicios.htm'>SELECT LANGUAGE:
		<OPTION VALUE='vcal.php?CIID=413&lang=en&month=05&year=2017'>English
		<OPTION VALUE='vcal.php?CIID=413&lang=es&month=05&year=2017'>Español
		<OPTION VALUE='vcal.php?CIID=413&lang=pt&month=05&year=2017'>Português
		</SELECT>
		</FORM>
	</td><td>
		<form>
		<select name=CIID onChange='return CheckCIIDSelect()' ID=CIID>
      <option value=0>SELECT COUNTRY AND CITY:</option>
      <option value='0' >ARGENTINA</option>
      <option value='4' >....Bhaía Blanca</option>
      <option value='5' >....Buenos Aires</option>
      <option value='6' >....Córdoba</option>
      <option value='7' >....Mar del Plata</option>
      <option value='8' >....Mendoza</option>
      <option value='9' >....Neuquén</option>
      <option value='10' >....Río Ceballos</option>
      <option value='11' >....Rosario</option>
      <option value='12' >....San Juan</option>
      <option value='504' >....San Luis</option>
      <option value='0' >ARMENIA ( &#1344;&#1377;&#1397;&#1377;&#1405;&#1407;&#1377;&#1398; )</option>
      <option value='3' >....Yerevan</option>
      <option value='0' >AUSTRALIA</option>
      <option value='13' >....Adelaide</option>
      <option value='14' >....Bambra - Victoria</option>
      <option value='15' >....Brisbane</option>
      <option value='16' >....Cairns</option>
      <option value='17' >....Canberra</option>
      <option value='18' >....Cessnocknsw</option>
      <option value='493' >....Darwin</option>
      <option value='19' >....Lismore</option>
      <option value='20' >....Melbourne</option>
      <option value='21' >....Murwillumbah</option>
      <option value='22' >....Perth</option>
      <option value='23' >....Sydney</option>
      <option value='24' >....Winchelsea</option>
      <option value='0' >AUSTRIA</option>
      <option value='25' >....Graz</option>
      <option value='26' >....Klagenfurt</option>
      <option value='27' >....Salzburg</option>
      <option value='28' >....St Aegyd</option>
      <option value='29' >....Vienna</option>
      <option value='0' >AZERBAIJAN ( AZ&#601;RBAYCAN )</option>
      <option value='30' >....Baku</option>
      <option value='0' >BAHRAIN ( &#8207;&#1575;&#1604;&#1576;&#1581;&#1585;&#1610;&#1606;&#8206; )</option>
      <option value='31' >....Manama</option>
      <option value='0' >BANGLADESH ( &#2476;&#2494;&#2434;&#2482;&#2494;&#2470;&#2503;&#2486; )</option>
      <option value='32' >....Cittagong</option>
      <option value='33' >....Dhaka</option>
      <option value='34' >....Jessore</option>
      <option value='0' >BARBADOS</option>
      <option value='35' >....Barbados</option>
      <option value='0' >BELARUS ( &#1041;&#1077;&#1083;&#1072;&#1088;&#1091;&#769;&#1089;&#1100; )</option>
      <option value='36' >....Minsk</option>
      <option value='0' >BELGIQUE</option>
      <option value='37' >....Antwerp</option>
      <option value='38' >....Brussels</option>
      <option value='39' >....Durbuy</option>
      <option value='40' >....Liege</option>
      <option value='0' >BOLIVIA</option>
      <option value='41' >....Cochabamba</option>
      <option value='42' >....La Paz</option>
      <option value='43' >....Santa Cruz</option>
      <option value='0' >BOSNIA AND HERZEGOWINA ( &#1041;&#1086;&#1089;&#1085;A &#1080; &#1061;&#1077;&#1088;&#1094;&#1077;&#1075;&#1086;&#1074;&#1080;&#1085;&#1072; )</option>
      <option value='44' >....Sarajevo</option>
      <option value='0' >BOTSWANA</option>
      <option value='478' >....Gaborone</option>
      <option value='0' >BRASIL</option>
      <option value='481' >....Areado</option>
      <option value='45' >....Belem</option>
      <option value='46' >....Belo Horizonte</option>
      <option value='47' >....Brasilia</option>
      <option value='48' >....Campos</option>
      <option value='49' >....Caruaru</option>
      <option value='50' >....Curitiba</option>
      <option value='51' >....Florianopolis</option>
      <option value='52' >....Fortaleza</option>
      <option value='53' >....Goiania</option>
      <option value='54' >....Guarulhos</option>
      <option value='56' >....Juiz de Foa</option>
      <option value='57' >....Jundiaí</option>
      <option value='58' >....Lambari</option>
      <option value='59' >....Manaus</option>
      <option value='495' >....Nova Gokula</option>
      <option value='60' >....Petropolis</option>
      <option value='61' >....Porto Alegre</option>
      <option value='62' >....Recife</option>
      <option value='63' >....Ribeirao Preto</option>
      <option value='64' >....Rio de Janeiro</option>
      <option value='65' >....Salvador</option>
      <option value='66' >....Santos</option>
      <option value='67' >....São Carlos</option>
      <option value='55' >....São José do Rio Preto</option>
      <option value='68' >....São Paulo</option>
      <option value='511' >....Suzano</option>
      <option value='69' >....Taubate</option>
      <option value='70' >....Ubatuba</option>
      <option value='71' >....Vitoria</option>
      <option value='0' >BULGARIYA</option>
      <option value='72' >....Plovdiv</option>
      <option value='73' >....Sofía</option>
      <option value='0' >CAMEROUN</option>
      <option value='74' >....Buea</option>
      <option value='0' >CANADA</option>
      <option value='75' >....AL - Calgary</option>
      <option value='76' >....AL - Edmonton</option>
      <option value='77' >....BC - Ashcroft</option>
      <option value='78' >....BC - Vancouver</option>
      <option value='81' >....NF - Placentia</option>
      <option value='79' >....ON - Ottawa</option>
      <option value='80' >....ON - Toronto</option>
      <option value='83' >....QC - Montreal</option>
      <option value='82' >....QC - Québec</option>
      <option value='84' >....SK - Regina</option>
      <option value='85' >....VC - Victoria</option>
      <option value='0' >CHINA ( &#20013;&#22283; )</option>
      <option value='88' >....Beijing</option>
      <option value='89' >....Hong Kong</option>
      <option value='494' >....Shangai</option>
      <option value='365' >....Taipei</option>
      <option value='0' >CHLE</option>
      <option value='86' >....Concepción</option>
      <option value='518' >....Pucon</option>
      <option value='87' >....Santiago</option>
      <option value='0' >COLOMBIA</option>
      <option value='457' >....Barranquilla</option>
      <option value='90' >....Bogotá</option>
      <option value='91' >....Cali</option>
      <option value='524' >....Medellin</option>
      <option value='92' >....Pereira</option>
      <option value='0' >COOK ISLANDS</option>
      <option value='499' >....Rarotonga</option>
      <option value='0' >COSTA RICA</option>
      <option value='93' >....San José</option>
      <option value='0' >CÔTE D IVORE</option>
      <option value='233' >....Abidjan</option>
      <option value='0' >CROATIA (HRVARSKA)</option>
      <option value='94' >....Osijek</option>
      <option value='95' >....Pula</option>
      <option value='96' >....Rijeka</option>
      <option value='97' >....Split</option>
      <option value='98' >....Zagreb</option>
      <option value='0' >CUBA</option>
      <option value='99' >....La Habana</option>
      <option value='0' >CYPRUS (KIBRIS)</option>
      <option value='100' >....Cyprus</option>
      <option value='0' >CZECH REPUBLIC ( &#268;ESKÁ )</option>
      <option value='101' >....Prague</option>
      <option value='102' >....Zlin</option>
      <option value='0' >DANMARK</option>
      <option value='103' >....Brorup</option>
      <option value='104' >....Copenhagen</option>
      <option value='0' >ECUADOR</option>
      <option value='106' >....Cuenca</option>
      <option value='107' >....Guayaquil</option>
      <option value='108' >....Quito</option>
      <option value='0' >EL SALVADOR</option>
      <option value='109' >....San Salvador</option>
      <option value='0' >ESTONIA ( EESTI )</option>
      <option value='110' >....Tallinn</option>
      <option value='0' >FIJI</option>
      <option value='111' >....Labasa</option>
      <option value='112' >....Lautoka</option>
      <option value='526' >....Sigatoga</option>
      <option value='113' >....Suva</option>
      <option value='0' >FINLAND ( SUOMI )</option>
      <option value='114' >....Helsinki</option>
      <option value='115' >....Tampere</option>
      <option value='116' >....Turku</option>
      <option value='0' >FRANÇAISE</option>
      <option value='117' >....Avignon</option>
      <option value='118' >....Bordeaux</option>
      <option value='119' >....Brest</option>
      <option value='120' >....Chateauroux</option>
      <option value='121' >....Dijón</option>
      <option value='122' >....Dole</option>
      <option value='123' >....Lille</option>
      <option value='124' >....Longwy</option>
      <option value='125' >....Lyon</option>
      <option value='126' >....Nice</option>
      <option value='127' >....Orange</option>
      <option value='128' >....Paris</option>
      <option value='129' >....Poitiers</option>
      <option value='130' >....Toulous</option>
      <option value='131' >....Valencay</option>
      <option value='0' >GEORGIA ( &#4321;&#4304;&#4325;&#4304;&#4320;&#4311;&#4309;&#4308;&#4314;&#4317; )</option>
      <option value='132' >....Tbilisi</option>
      <option value='0' >GERMANY ( DEUTSCHLAND )</option>
      <option value='133' >....Berlin</option>
      <option value='134' >....Bremerhaven</option>
      <option value='135' >....Dresden</option>
      <option value='136' >....Flensburg</option>
      <option value='137' >....Frankfurt</option>
      <option value='139' >....Hamburg</option>
      <option value='140' >....Hannover</option>
      <option value='141' >....Heidelberg</option>
      <option value='142' >....Heilbronn</option>
      <option value='143' >....Karlsruhe</option>
      <option value='144' >....Kiel</option>
      <option value='145' >....Koblenz</option>
      <option value='146' >....Köln (Cologne)</option>
      <option value='147' >....Leipzig</option>
      <option value='148' >....Marburg</option>
      <option value='149' >....München (Munich)</option>
      <option value='150' >....Nurnberg (Nuremberg)</option>
      <option value='151' >....Paderborn</option>
      <option value='152' >....Passau</option>
      <option value='153' >....Saarbrucken</option>
      <option value='154' >....Salzwedel</option>
      <option value='155' >....Schwerin</option>
      <option value='466' >....Simhachalam</option>
      <option value='156' >....Stuttgart</option>
      <option value='157' >....Trier</option>
      <option value='158' >....Ulm</option>
      <option value='482' >....Ummern</option>
      <option value='159' >....Weimar</option>
      <option value='160' >....Wiesbaden</option>
      <option value='0' >GHANA</option>
      <option value='161' >....Accra</option>
      <option value='162' >....Nkawkaw</option>
      <option value='163' >....Takoradi</option>
      <option value='0' >GRECE ( &#917;&#955;&#955;&#940;&#962; )</option>
      <option value='164' >....Athens</option>
      <option value='0' >GUATEMALA</option>
      <option value='165' >....Guatemala</option>
      <option value='0' >GUYANA</option>
      <option value='166' >....Berbice</option>
      <option value='167' >....Essequibo Coast</option>
      <option value='168' >....Georgetown</option>
      <option value='0' >HONDURAS</option>
      <option value='169' >....Tegucigalpa</option>
      <option value='0' >HUNGARY ( MAGYARORSZÁG )</option>
      <option value='170' >....Budapest</option>
      <option value='171' >....Debrecen</option>
      <option value='172' >....Kaposvar</option>
      <option value='173' >....Szolnok</option>
      <option value='0' >ICELAND</option>
      <option value='174' >....Reykjavik</option>
      <option value='0' >INDIA ( &#2349;&#2366;&#2352;&#2340; )</option>
      <option value='530' >....AP - Giridhari Kunj</option>
      <option value='175' >....AP - Guntur</option>
      <option value='176' >....AP - Hyderabad</option>
      <option value='177' >....AP - Secunderabad</option>
      <option value='178' >....AP - Tirupati</option>
      <option value='179' >....AS - Guwahati</option>
      <option value='180' >....AS - Silchar</option>
      <option value='181' >....BI - Patna</option>
      <option value='182' >....CH - Chandigarh</option>
      <option value='183' >....GU - Ahmedabad</option>
      <option value='473' >....GU - Anand</option>
      <option value='184' >....GU - Dwaraka</option>
      <option value='185' >....GU - Surat</option>
      <option value='186' >....GU - Vadodara (Baroda)</option>
      <option value='475' >....GU - Vallabh Vidyanagar</option>
      <option value='497' >....HY - Faridabad</option>
      <option value='187' >....JK - Udhampur</option>
      <option value='188' >....KA - Bangalore</option>
      <option value='189' >....KA - Belgaum</option>
      <option value='190' >....KA - Mangalore</option>
      <option value='517' >....KE - Kozhikode</option>
      <option value='191' >....KE - Thiruvananthapuram</option>
      <option value='192' >....KE - Trivandrum</option>
      <option value='198' >....MA - Imphal</option>
      <option value='199' >....MA - Moirang</option>
      <option value='467' >....MP - Ujjain</option>
      <option value='193' >....MR - Aurangabad</option>
      <option value='194' >....MR - Mumbai (Bombay)</option>
      <option value='195' >....MR - Nagpur</option>
      <option value='196' >....MR - Pandharpur</option>
      <option value='197' >....MR - Pune</option>
      <option value='200' >....ND - New Delhi</option>
      <option value='201' >....OR - Bhubaneswar</option>
      <option value='202' >....OR - Puri</option>
      <option value='505' >....OR - Rourkela</option>
      <option value='480' >....PU - Amristar</option>
      <option value='472' >....PU - Jalandhar</option>
      <option value='471' >....PU - Ludiana</option>
      <option value='203' >....RA - Jaipur</option>
      <option value='205' >....TN - Chennai (Madras)</option>
      <option value='204' >....TN - Coimbatore</option>
      <option value='206' >....TN - Srirangam</option>
      <option value='207' >....TR - Agartala</option>
      <option value='208' >....UP - Allahabad</option>
      <option value='209' >....UP - Hardwar</option>
      <option value='210' >....UP - Lucknow</option>
      <option value='211' >....UP - Mathura</option>
      <option value='509' >....UP - Meerut</option>
      <option value='212' >....UP - Vrindavan</option>
      <option value='213' >....WB - Calcutta</option>
      <option value='214' >....WB - Mayapur</option>
      <option value='529' >....WB - Murishidabad</option>
      <option value='215' >....WB - Navadwip</option>
      <option value='216' >....WB - Siliguri</option>
      <option value='0' >INDONESIA</option>
      <option value='217' >....Bali</option>
      <option value='218' >....Bogor</option>
      <option value='219' >....Denpasar</option>
      <option value='220' >....Jakarta</option>
      <option value='453' >....Jogjakarta</option>
      <option value='0' >IRAN ( &#1575;&#1740;&#1585;&#1575;&#1606; )</option>
      <option value='221' >....Teheran</option>
      <option value='0' >IRELAND (IRISH)</option>
      <option value='374' >....Dublin</option>
      <option value='383' >....Wexford</option>
      <option value='0' >IRELAND N ( ÉIRE )</option>
      <option value='285' >....Belfast</option>
      <option value='286' >....Derrylin</option>
      <option value='0' >ISRAEL ( &#1497;&#1460;&#1513;&#1456;&#1474;&#1512;&#1464;&#1488;&#1461;&#1500; )</option>
      <option value='222' >....Telaviv</option>
      <option value='0' >ITALIA</option>
      <option value='223' >....Bergamo</option>
      <option value='224' >....Bologna</option>
      <option value='225' >....Catania</option>
      <option value='226' >....Firenze (Florence)</option>
      <option value='227' >....Milán</option>
      <option value='228' >....Napoli (Naples)</option>
      <option value='229' >....Padua</option>
      <option value='230' >....Pisa</option>
      <option value='231' >....Roma</option>
      <option value='528' >....Torino</option>
      <option value='488' >....Verona</option>
      <option value='232' >....Vicenza</option>
      <option value='0' >JAPAN ( &#26085;&#26412;&#22269; )</option>
      <option value='533' >....Fukuoka</option>
      <option value='234' >....Okinawa</option>
      <option value='235' >....Sapporo</option>
      <option value='236' >....Tokyo</option>
      <option value='0' >KAZAKHSTAN ( &#1178;&#1072;&#1079;&#1072;&#1179;&#1089;&#1090;&#1072;&#1085; )</option>
      <option value='237' >....Alma-ata</option>
      <option value='0' >KENYA</option>
      <option value='238' >....Kisumu</option>
      <option value='239' >....Mombasa</option>
      <option value='240' >....Nairobi</option>
      <option value='0' >KUWAIT ( &#1583;&#1608;&#1604;&#1577; &#1575;&#1604;&#1603;&#1608;&#1610;&#1578; )</option>
      <option value='474' >....Kuwait</option>
      <option value='0' >LATVIJA</option>
      <option value='241' >....Riga</option>
      <option value='0' >LITHUANIA ( LIETUVA )</option>
      <option value='242' >....Alytus</option>
      <option value='243' >....Druskininkai</option>
      <option value='244' >....Kaunas</option>
      <option value='245' >....Klaipeda</option>
      <option value='246' >....Mazheikiai</option>
      <option value='247' >....Panevezhys</option>
      <option value='248' >....Shyaulyai</option>
      <option value='249' >....Utena</option>
      <option value='250' >....Vilnius</option>
      <option value='0' >MACEDONIA ( &#1052;&#1072;&#1082;&#1077;&#1076;&#1086;&#1085;&#1080;&#1112;&#1072; )</option>
      <option value='506' >....Skopje</option>
      <option value='0' >MALAYSIA</option>
      <option value='251' >....Bukit Mertajam</option>
      <option value='252' >....Ipoh</option>
      <option value='253' >....Kuala Lumpur</option>
      <option value='254' >....Perak</option>
      <option value='0' >MAURITIUS</option>
      <option value='255' >....Mauritius</option>
      <option value='0' >MÉXICO</option>
      <option value='256' >....Cancún</option>
      <option value='523' >....Colima</option>
      <option value='257' >....Culiacán</option>
      <option value='507' >....Durango</option>
      <option value='258' >....Guadalajara</option>
      <option value='532' >....La Paz</option>
      <option value='259' >....León</option>
      <option value='260' >....Loreto</option>
      <option value='261' >....Mexico City</option>
      <option value='262' >....Monterrey</option>
      <option value='263' >....Morelia</option>
      <option value='483' >....Pachuca</option>
      <option value='264' >....Saltillo</option>
      <option value='484' >....San Luis Potosí</option>
      <option value='265' >....Tijuana</option>
      <option value='500' >....Torreón</option>
      <option value='266' >....Tulancingo</option>
      <option value='267' >....Veracruz</option>
      <option value='268' >....Villahermosa</option>
      <option value='0' >NEPAL</option>
      <option value='269' >....Kathmandu</option>
      <option value='0' >NETHERLANDS (NEDERLANDEN)</option>
      <option value='270' >....Amsterdam</option>
      <option value='460' >....Den Haag</option>
      <option value='271' >....Utrecht</option>
      <option value='0' >NEW ZEALAND ( AOTEAROA )</option>
      <option value='272' >....Auckland</option>
      <option value='273' >....Christchurch</option>
      <option value='508' >....Hamilton</option>
      <option value='274' >....Wellington</option>
      <option value='0' >NICARAGUA</option>
      <option value='275' >....Chinandega</option>
      <option value='276' >....Managua</option>
      <option value='0' >NIGERIA</option>
      <option value='277' >....Abeokuta</option>
      <option value='278' >....Benin City</option>
      <option value='279' >....Enugu</option>
      <option value='280' >....Ibadan</option>
      <option value='281' >....Kaduna</option>
      <option value='282' >....Lagos</option>
      <option value='283' >....Porth Arcourt</option>
      <option value='284' >....Warri</option>
      <option value='0' >NORWAY ( NORGE )</option>
      <option value='287' >....Bergen</option>
      <option value='288' >....Oslo</option>
      <option value='0' >PAKISTAN ( &#1662;&#1575;&#1603;&#1587;&#1578;&#1575;&#1606;&#8206; )</option>
      <option value='492' >....Karachi</option>
      <option value='0' >PANAMÁ</option>
      <option value='289' >....Panamá</option>
      <option value='0' >PAPUA NEW GUINEA ( PAPUA NIUGINI )</option>
      <option value='290' >....Port Morseby</option>
      <option value='0' >PARAGUAY</option>
      <option value='291' >....Asunción</option>
      <option value='0' >PERÚ</option>
      <option value='292' >....Arequipa</option>
      <option value='498' >....Chiclayo</option>
      <option value='293' >....Cuzco</option>
      <option value='513' >....Huancayo</option>
      <option value='514' >....Huanuco</option>
      <option value='476' >....Ica</option>
      <option value='294' >....Iquitos</option>
      <option value='295' >....Lima</option>
      <option value='459' >....Neuquén</option>
      <option value='296' >....Puno</option>
      <option value='297' >....Salcabamba</option>
      <option value='515' >....Satipo</option>
      <option value='298' >....Tarapoto</option>
      <option value='516' >....Trujillo</option>
      <option value='0' >PHILIPPINES ( PILIPINAS )</option>
      <option value='299' >....Cagayan</option>
      <option value='300' >....Cebu</option>
      <option value='301' >....Iloilo</option>
      <option value='302' >....Manila</option>
      <option value='0' >POLAND ( POLSKA )</option>
      <option value='303' >....Gdansk</option>
      <option value='304' >....Gorzow</option>
      <option value='305' >....Warsaw</option>
      <option value='306' >....Wroclaw</option>
      <option value='0' >PORTUGAL</option>
      <option value='307' >....Lisboa</option>
      <option value='308' >....Oporto</option>
      <option value='0' >REPUBLICA DOMINICANA</option>
      <option value='105' >....Santo Domingo</option>
      <option value='0' >ROMÂNIA</option>
      <option value='309' >....Bucharest</option>
      <option value='310' >....Timisoara</option>
      <option value='0' >RUSSIA ( &#1056;&#1086;&#1089;&#1089;&#1080;&#1103; )</option>
      <option value='311' >....Ekaterinburg</option>
      <option value='312' >....Krasnoyarsk</option>
      <option value='313' >....Moscow</option>
      <option value='314' >....Novosibirsk</option>
      <option value='315' >....St Petersburg</option>
      <option value='316' >....Vladikavkaz</option>
      <option value='317' >....Vladivostok</option>
      <option value='0' >SAUDI ARABIA ( &#1575;&#1604;&#1605;&#1605;&#1604;&#1603;&#1577; &#1575;&#1604;&#1593;&#1585;&#1576;&#1610;&#1577; &#1575;&#1604;&#1587;&#1593;&#1608;&#1583;&#1610;&#1577; )</option>
      <option value='522' >....Damman ( &#1575;&#1604;&#1583;&#1605;&#1575;&#1605;&#8206; )</option>
      <option value='521' >....Jeddah ( &#1580;&#1583;&#1617;&#1577; )</option>
      <option value='520' >....Riyadh ( &#1604;&#1585;&#1610;&#1575;&#1590;&#8206; )</option>
      <option value='0' >SERBIA ( &#1057;&#1088;&#1073;&#1080;&#1112;&#1072; )</option>
      <option value='318' >....Belgrade</option>
      <option value='319' >....Sombor</option>
      <option value='0' >SEYCHELLES ( SESEL )</option>
      <option value='465' >....Victoria</option>
      <option value='0' >SIERRA LEONE</option>
      <option value='320' >....Freetown</option>
      <option value='0' >SINGAPORE</option>
      <option value='321' >....Singapore</option>
      <option value='0' >SLOVAK REPUBLIC ( SLOVENSKÁ )</option>
      <option value='322' >....Bratislava</option>
      <option value='479' >....Nova Ekacakra</option>
      <option value='323' >....Trnava</option>
      <option value='0' >SLOVENIA ( SLOVENIJA )</option>
      <option value='324' >....Ljubljana</option>
      <option value='0' >SOUTH AFRICA</option>
      <option value='325' >....Cape Town</option>
      <option value='326' >....Durban</option>
      <option value='327' >....Johannesburg</option>
      <option value='328' >....Port Elizabeth</option>
      <option value='0' >SOUTH COREA ( &#45824;&#54620;&#48124;&#44397; )</option>
      <option value='519' >....Seoul</option>
      <option value='0' >SPAIN (ESPAÑA)</option>
      <option value='329' >....Barcelona</option>
      <option value='330' >....Brihuega</option>
      <option value='331' >....Galicia</option>
      <option value='458' >....Guadalajara</option>
      <option value='332' >....Is. Canarias</option>
      <option value='334' >....Madrid</option>
      <option value='335' >....Málaga</option>
      <option value='336' >....Santa Cruz de Tenerife</option>
      <option value='337' >....Valencia</option>
      <option value='0' >SRI LANKA ( &#2965;&#3009;&#2975;&#3007;&#2991;&#2992;&#2970;&#3009; )</option>
      <option value='338' >....Colombo</option>
      <option value='0' >SURINAME</option>
      <option value='491' >....Nieuw Nickerie</option>
      <option value='339' >....Paramaribo</option>
      <option value='0' >SWEDEN ( SVERIGE )</option>
      <option value='340' >....Avesta</option>
      <option value='341' >....Gothenburg</option>
      <option value='343' >....Haparanda</option>
      <option value='344' >....Horby</option>
      <option value='345' >....Jonkoping</option>
      <option value='346' >....Karlstad</option>
      <option value='347' >....Ludvika</option>
      <option value='348' >....Lulea</option>
      <option value='349' >....Lund</option>
      <option value='350' >....Mälmo</option>
      <option value='351' >....Stockholm</option>
      <option value='352' >....Sundsvall</option>
      <option value='353' >....Umea</option>
      <option value='354' >....Uppsala</option>
      <option value='355' >....Visby</option>
      <option value='356' >....Östersund</option>
      <option value='0' >SWITZERLAND ( SVIZRA )</option>
      <option value='357' >....Basel</option>
      <option value='358' >....Bern</option>
      <option value='359' >....Düdingen</option>
      <option value='360' >....Geneva</option>
      <option value='361' >....Lugano</option>
      <option value='362' >....Schaffhausen</option>
      <option value='363' >....Zürich</option>
      <option value='0' >SYRIA ( &#1587;&#1608;&#1585;&#1610;&#1575; )</option>
      <option value='364' >....Al Quneitrah</option>
      <option value='0' >THAILAND ( &#3611;&#3619;&#3632;&#3648;&#3607;&#3624;&#3652;&#3607;&#3618; )</option>
      <option value='366' >....Bangkok</option>
      <option value='0' >TRINIDAD AND TOBAGO</option>
      <option value='367' >....Trinidad</option>
      <option value='0' >TURKEY ( TÜRKIYE )</option>
      <option value='454' >....Ankara</option>
      <option value='455' >....Istambul</option>
      <option value='456' >....Izhir</option>
      <option value='0' >UGANDA</option>
      <option value='368' >....Kampala</option>
      <option value='0' >UKRAINE ( &#1059;&#1082;&#1088;&#1072;&#1111;&#1085;&#1072; )</option>
      <option value='385' >....Kiev</option>
      <option value='386' >....Odessa</option>
      <option value='0' >UNITED ARAB EMIRATES ( &#1575;&#1604;&#1573;&#1605;&#1575;&#1585;&#1575;&#1578; &#1575;&#1604;&#1593;&#1585;&#1576;&#1610;&#1577; &#1575;&#1604;&#1605;&#1578;&#1581;&#1583;&#1577; )</option>
      <option value='477' >....Abu Dhabi</option>
      <option value='469' >....Dubai</option>
      <option value='0' >UNITED KINGDOM</option>
      <option value='369' >....Birmingham</option>
      <option value='370' >....Bristol</option>
      <option value='371' >....Cardiff</option>
      <option value='372' >....Cleethorpes</option>
      <option value='373' >....Coventry</option>
      <option value='375' >....Glasgow</option>
      <option value='501' >....Great Bricet</option>
      <option value='376' >....Leicester</option>
      <option value='377' >....Liverpool</option>
      <option value='378' >....London</option>
      <option value='379' >....Manchester</option>
      <option value='380' >....New Castle</option>
      <option value='381' >....Plymouth</option>
      <option value='382' >....Romford</option>
      <option value='384' >....Worcester</option>
      <option value='0' >UNITED STATES</option>
      <option value='389' >....AL - Juneau</option>
      <option value='390' >....AZ - Phoenix</option>
      <option value='391' >....AZ - Tucson</option>
      <option value='503' >....CA  - Oakland</option>
      <option value='392' >....CA - Arcata</option>
      <option value='393' >....CA - Berkeley</option>
      <option value='394' >....CA - Los Angeles</option>
      <option value='395' >....CA - Palo Alto</option>
      <option value='527' >....CA - Sacramento</option>
      <option value='396' >....CA - San Diego</option>
      <option value='397' >....CA - San Francisco</option>
      <option value='398' >....CA - San Jose</option>
      <option value='399' >....CA - San Luis Obispo</option>
      <option value='400' >....CO - Boulder</option>
      <option value='401' >....CO - Denver</option>
      <option value='402' >....CT - Hartford</option>
      <option value='403' >....DC - Washington</option>
      <option value='404' >....FL - Gainesville</option>
      <option value='405' >....FL - Key West</option>
      <option value='406' >....FL - Miami</option>
      <option value='407' >....FL - Tallahassee</option>
      <option value='408' >....FL - Tampa</option>
      <option value='409' >....GA - Atlanta</option>
      <option value='410' >....HI - Hilo</option>
      <option value='411' >....HI - Honolulu</option>
      <option value='412' >....ID - Boise</option>
      <option value='413' selected>....IL - Chicago</option>
      <option value='502' >....IN - Indianapolis</option>
      <option value='414' >....LA - New Orleans</option>
      <option value='416' >....MA - Boston</option>
      <option value='415' >....MD - Baltimore</option>
      <option value='417' >....MI - Detroit</option>
      <option value='418' >....MI - Lansing</option>
      <option value='496' >....MN - Mineapolis</option>
      <option value='420' >....MO - St Louis</option>
      <option value='419' >....MS - Picayune</option>
      <option value='424' >....NC - Chapelhill</option>
      <option value='425' >....NC - Durham</option>
      <option value='485' >....NC - Hillsborough</option>
      <option value='531' >....NC - Sandy Ridge</option>
      <option value='426' >....NC - Winston-Salem</option>
      <option value='421' >....NJ - Morristown</option>
      <option value='422' >....NM - Alburquerque</option>
      <option value='423' >....NY - New York</option>
      <option value='470' >....NY - Syracuse</option>
      <option value='427' >....OH - Cleveland</option>
      <option value='428' >....OH - Columbus</option>
      <option value='429' >....OK - Oklahoma City</option>
      <option value='431' >....OR - Eugene</option>
      <option value='430' >....OR - Portland</option>
      <option value='432' >....PA - Gita-nagari Farm</option>
      <option value='433' >....PA - Harrisburg</option>
      <option value='434' >....PA - Philadelphia</option>
      <option value='435' >....PA - Pittsburgh</option>
      <option value='525' >....PA - Reading</option>
      <option value='436' >....PR - Puerto Rico</option>
      <option value='437' >....PR - San Juan</option>
      <option value='438' >....SC - Charleston</option>
      <option value='388' >....Territory - Virgin Islands</option>
      <option value='439' >....TX - Austin</option>
      <option value='440' >....TX - Dallas</option>
      <option value='490' >....TX - Harlingen</option>
      <option value='441' >....TX - Houston</option>
      <option value='442' >....TX - Waco</option>
      <option value='443' >....UT - Provo</option>
      <option value='444' >....WS - Seattle</option>
      <option value='445' >....WS - Walla Walla</option>
      <option value='446' >....WV - Moundsville</option>
      <option value='447' >....WV - New Vrindaban</option>
      <option value='0' >URUGUAY</option>
      <option value='387' >....Montevideo</option>
      <option value='0' >UZBEKISTAN ( O&#699;ZBEKISTON )</option>
      <option value='448' >....Tashkent</option>
      <option value='0' >VENEZUELA</option>
      <option value='449' >....Caracas</option>
      <option value='0' >ZAMBIA</option>
      <option value='450' >....Kitwe-nkana</option>
      <option value='451' >....Lusaka</option>
      <option value='0' >ZIMBABWE</option>
      <option value='452' >....Harare</option></select>
		</form>
	</td><tr><tr><td colspan=2>
		<select name=code  onChange='return CheckSelectHoliday()' ID=code>
      <option value=0>SEARCH FOR HOLIDAY:</option>
      <option value='00080' >Gaura Purnima</option>
      <option value='00082' >Nityananda Trayodasi</option>
      <option value='00083' >Sri Krsna Janmastami</option>
      <option value='00084' >Radhastami</option>
      <option value='00085' >Appearance of Lord Balarama</option>
      <option value='00087' >Rama Navami</option>
      <option value='00088' >Nrsimha Caturdasi</option>
      <option value='00089' >Sri Vamana Dvadasi</option>
      <option value='00086' >Varaha Dvadasi</option>
      <option value='' ></option>
      <option value='00213' ><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=rathayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Ratha Yatra</a> (Jagannatha Puri)</option>
      <option value='00225' ><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=jhulanayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Radha Govinda Jhulana Yatra begins</a></option>
      <option value='00226' >Radha Govinda <a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=jhulanayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Jhulana Yatra ends</a></option>
      <option value='A908' >Damodara Masa begin</option>
      <option value='A909' >Damodara Masa ends</option>
      <option value='00059' >Caturmasya begins</option>
      <option value='00058' >Caturmasya ends</option>
      <option value='00036' >Pandava Nirjala Ekadasi</option>
      <option value='00201' ><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=govardhanapuja','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Govardhana Puja, Go Puja, Go Krda</a></option>
      <option value='' ></option>
      <option value='00090' >Sri Advaita Acarya Appearance</option>
      <option value='00091' >Srila Gaura Kisora Dasa Babaji Dissappearance</option>
      <option value='00092' >Srila Bhaktivinoda Thakura Appearance</option>
      <option value='00093' >Srila Bhaktivinoda Thakura Dissappearance</option>
      <option value='00095' >Srila Bhaktisiddhanta Sarasvati Thakura Appearance</option>
      <option value='00094' >Srila Bhaktisiddhanta Sarasvati Thakura Dissappearance</option>
      <option value='00096' >Srila Prabhupada Appearance</option>
      <option value='00097' >Srila Prabhupada Dissappearance</option>
      <option value='' ></option>
      <option value='A028' >HH BB Govinda Svami Vyasa-puja</option>
      <option value='A003' >HH Bhaktibusana Svami Vyasa-puja</option>
      <option value='A049' >HH Bhakti Caitanya Svami Vyasa-puja</option>
      <option value='A016' >HH Bhakti Caru Svami Vyasa-puja</option>
      <option value='A055' >HH Bhakti Raghava Svami Vyasa-puja</option>
      <option value='A026' >HH Bhaktisvarupa Damodar Svami Dissappearance</option>
      <option value='A014' >HH Bhaktitirtha Svami Dissappearance</option>
      <option value='A039' >HH Bir Krishna dasa Gosvami Vyasa-puja</option>
      <option value='A051' >HH Danavir Gosvami Vyasa-puja</option>
      <option value='A047' >HH Chandramukha Svami Vyasa-puja</option>
      <option value='A051' >HH Danavir Gosvami Vyasa-puja</option>
      <option value='A005' >HH Devamrta Svami Vyasa-puja</option>
      <option value='A008' >HH Dhanvantari Svami Vyasa-puja</option>
      <option value='0035' >HH Gopal Krishna Gosvami Vyasa-puja</option>
      <option value='0037' >HH Gour Govinda Svami Vyasa-puja</option>
      <option value='00102' >HH Gour Govinda Svami Dissapearance</option>
      <option value='A012' >HH Hanumatpresaka Svami Vyasa-puja</option>
      <option value='A001' >HH Hridayananda Dasa Gosvami Vyasa-puja</option>
      <option value='A022' >HH Indradyumna Svami Vyasa-puja</option>
      <option value='A004' >HH Jayapataka Svami Vyasa-puja</option>
      <option value='A033' >HH Kadamba Kanana Svami Vyasa-puja</option>
      <option value='A059' >HH Kavicandra Svami Vyasa-puja</option>
      <option value='A018' >HG Kratu Prabhu Vyasa-puja</option>
      <option value='A002' >HG Krishna Ksetra Dasa Vyasa-puja</option>
      <option value='A023' >HH Lokanath Svami Vyasa-puja</option>
      <option value='A057' >HH Mahavisnu Gosvami Vyasa-puja</option>
      <option value='A020' >HH Niranjana Svami Vyasa-puja</option>
      <option value='A053' >HH Partha Sarathi Gosvami Vyasa-puja</option>
      <option value='A041' >HH Radhanath Svami Vyasa-puja</option>
      <option value='A030' >HH Satsvarupa dasa Gosvami Vyasa-puja</option>
      <option value='A010' >HH Smita Krishna Svami Vyasa-puja</option>
      <option value='A061' >HH Subhag Svami Vyasa-puja</option>
      <option value='A006' >HH Sridhara Svami Vyasa-puja</option>
      <option value='A007' >HH Sridhara Svami Dissappearance</option>
      <option value='A015' >HH Tamal Krishna Gosvami Vyasa-puja</option>
      <option value='A009' >HH Tamal Krishna Gosvami Dissappearance</option>
      <option value='A045' >HH Vedavyasapriya Svami Vyasa-puja</option></select>
	</td></tr></table>
</td><td valign=bottom>
	<iframe src='//www.facebook.com/plugins/like.php?href=https%3A%2F%2Fwww.facebook.com%2FVaisnavaCalendar&amp;width=325&amp;layout=standard&amp;action=like&amp;show_faces=true&amp;share=false&amp;height=80&amp;appId=1374613962823729' scrolling='no' frameborder='0' style='border:none; overflow:hidden; height:80px;' allowTransparency='true'></iframe>
</td></tr>
</table>
<TABLE BORDER=1 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>
  <tr>
    <td width=1% rowspan=8></td>
    <TD width=14% bgcolor=#6F6E6E><center><b>Sunday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Monday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Tuesday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Wednesday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Thursday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Friday</TD>
    <TD width=14% bgcolor=#6F6E6E><center><b>Saturday</TD>
    <td width=1% rowspan=8></td>
   </TR>

    <tr>
       <td height=80 valign=top>&nbsp;
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Sasti</td>
          <td align=center valign=top>1</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Saptami</td>
          <td align=center valign=top>2</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=jahnusaptami','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Jahnu Saptami</a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Astami</td>
          <td align=center valign=top>3</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Navami</td>
          <td align=center valign=top>4</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=sitadevi','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srimati Sita Devi (consort of Lord Sri Rama) <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=madhupandita','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Madhu Pandita <img src=dis.gif alt=Disppearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=jahnavadevi','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srimati Jahnava Devi <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Dasami</td>
          <td align=center valign=top>5</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Suddha Ekadasi</td>
          <td align=center valign=top>6</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top>Mohini Ekadasi</td>
             </tr>
        </table>
      </td>
   </tr>
    <tr>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Dvadasi</td>
          <td align=center valign=top>7</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#862E98  valign=top><font size=1>Break fast 04:39 - 09:25 <br>(Daylight saving not considered)</font></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=rukminidvadasi','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Rukmini Dvadasi</a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href="javascript:;" onClick="window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=gurukks','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">HH Kadamba Kanana Svami <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Trayodasi</td>
          <td align=center valign=top>8</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=jayanandathakura','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">HG Jayananda Thakura (ACBSP)<img src=dis.gif alt=Disppearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Caturdasi</td>
          <td align=center valign=top>9</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#414AFC  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=nrsimhacaturdasi','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Nrsimha Caturdasi</a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><font size=1>(Fasting till dusk)</font></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Purnima</td>
          <td align=center valign=top>10</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=krishnaphuladola','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Krsna Phula Dola, Salila Vihara</a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=paramesvaridasathakura','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Paramesvari Dasa Thakura <img src=dis.gif alt=Disppearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=radharamanadevaji','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Sri Radha-Ramana Devaji <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=madhavendrapuri','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Madhavendra Puri <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=srinivasaacarya','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Srinivasa Acarya <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=E87AFF height=100% valign=top><img src="purnima.gif" border=0></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Pratipat</td>
          <td align=center valign=top>11</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=6F6E6E height=100% valign=top><b>Trivikrama Masa</b></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Dvitiya</td>
          <td align=center valign=top>12</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Tritiya</td>
          <td align=center valign=top>13</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=salagramatulasijaladana','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">End of Jala Dana</a></td>
             </tr>
        </table>
      </td>
   </tr>
    <tr>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Caturthi</td>
          <td align=center valign=top>14</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top>Taurus</td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Pancami</td>
          <td align=center valign=top>15</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=ramanandaraya','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Ramananda Raya <img src=dis.gif alt=Disppearance border=0></a></td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href="javascript:;" onClick="window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=gurubrs','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">HH Bhakti Raghava Svami <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Sasti</td>
          <td align=center valign=top>16</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Sasti</td>
          <td align=center valign=top>17</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Saptami</td>
          <td align=center valign=top>18</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Astami</td>
          <td align=center valign=top>19</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href="javascript:;" onClick="window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=guruids','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">HH Indradyumna Svami <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Navami</td>
          <td align=center valign=top>20</td>
         </tr>
        </table>
      </td>
   </tr>
    <tr>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Dasami</td>
          <td align=center valign=top>21</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Suddha Ekadasi</td>
          <td align=center valign=top>22</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#862E98  valign=top>Apara Ekadasi</td>
             </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href="javascript:;" onClick="window.open('/cgi-bin/en.cgi?nam=vrndavanadasathakura','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Srila Vrndavana Dasa Thakura <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Trayodasi</td>
          <td align=center valign=top>23</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top><font size=1>Break fast 04:24 - 09:20 <br>(Daylight saving not considered)</font></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Caturdasi</td>
          <td align=center valign=top>24</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Amavasya</td>
          <td align=center valign=top>25</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=E87AFF height=100% valign=top><img src=amavasya.gif border=0></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Pratipat</td>
          <td align=center valign=top>26</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Dvitiya</td>
          <td align=center valign=top>27</td>
         </tr>
        </table>
      </td>
   </tr>
    <tr>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Caturthi</td>
          <td align=center valign=top>28</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Pancami</td>
          <td align=center valign=top>29</td>
         </tr>
             <tr>
              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href="javascript:;" onClick="window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=gurusks','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">HH Smita Krishna Svami <img src=ap.gif alt=Appearance border=0></a></td>
             </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Sasti</td>
          <td align=center valign=top>30</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>
        <table border=0 width=100% height=100%>
         <tr>
          <td align=center valign=top>Saptami</td>
          <td align=center valign=top>31</td>
         </tr>
        </table>
      </td>
       <td height=80 valign=top>&nbsp;
      </td>
       <td height=80 valign=top>&nbsp;
      </td>
       <td height=80 valign=top>&nbsp;
      </td>
   </tr>
</TABLE>

<BR><center>
<table border=0 CELLSPACING=2>
	<tr></td><td>
       	<img src=purnima.gif> Full moon |
	</td><td>
       	<img src=amavasya.gif> New moon |
	</td><td>
       	<img src=ap.gif height=16> Appearance |
	</td><td>
       	<img src=dis.gif height=16> Dissapearence |
	</td><td width=19 bgcolor=862E98></td><td>
		Ekadasi |
	</td><td width=19 bgcolor=559FFB></td><td>
		Caturmasya
	</td></tr>
</table>

<br>
<CENTER><b><a href='http://www.iskcon.com.mx/daksina/index.php?lang=en' target=_blank>Help us to preach</a> | <a href="javascript:;" onClick="window.open('/add_en.php','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false">Add Vaisnava Calendar to your webpage</a>
<br><br><SCRIPT SRC='http://www.iskcon.com.mx/cgi-bin/carousel.cgi?tell=js'></SCRIPT></CENTER>


</BODY>
</HTML>

"""

