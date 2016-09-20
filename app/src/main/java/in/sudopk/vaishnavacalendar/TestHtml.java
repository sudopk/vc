package in.sudopk.vaishnavacalendar;

public class TestHtml {
    public static final String HTMl =
            "\n" +
                    "\n" +
                    "\n" +
                    "<HTML>\n" +
                    "<HEAD>\n" +
                    "<TITLE>Vaisnava VCalendar</TITLE>\n" +
                    "<meta name='author' content='.'>\n" +
                    "<meta name='keywords' content='.'>\n" +
                    "<meta http-equiv='Content-Type' content='text/html;charset=iso-8859-1'>\n" +
                    "<meta name='distribution' content='global'>\n" +
                    "<meta name='resource-type' content='document'>\n" +
                    "<meta name='robots' content='all'>\n" +
                    "<link rel='stylesheet' href='style.css' type='text/css'>\n" +
                    "\n" +
                    "<SCRIPT language=JavaScript>\n" +
                    "/*\n" +
                    "* DHTML Menu version 3.3\n" +
                    "* written by Andy Woolley\n" +
                    "* Copyright 2002 Andy Woolley. All Rights Reserved.\n" +
                    "*\n" +
                    "* Please feel free to use this code on your own website free of charge.\n" +
                    "* You can also distribute and modify this source code as long as this\n" +
                    "* Copyright notice remains intact and that you send me notice that you\n" +
                    "* intend to use this code on your website. \t\n" +
                    "*\n" +
                    "* Limited support for this script is provided\n" +
                    "* Commercial licence agreements are available on request for full support.\n" +
                    "* You can send email to menu3@milonic.com \n" +
                    "*/\n" +
                    "</SCRIPT>\n" +
                    "\n" +
                    "<script>\n" +
                    " function CheckCIIDSelect()\n" +
                    "  {\n" +
                    "   val=document.getElementById('CIID').value;\n" +
                    "   if (val==0) return false;\n" +
                    "   document.location='vcal.php?month=07&year=2016&lang=en&CIID='+val;\n" +
                    "   return true;\n" +
                    "  }\n" +
                    "\n" +
                    "function CheckSelectHoliday()\n" +
                    " {\n" +
                    "   val=document.getElementById('code').value;\n" +
                    "   if (val==0) return false;\n" +
                    "   window.location='search.php?month=07&year=2016&lang=en&CIID=398&code='+val;\n" +
                    "   return true;\n" +
                    "  \n" +
                    " }\n" +
                    "\n" +
                    "</script>\n" +
                    "\n" +
                    "<SCRIPT language=JavaScript src='../menues/scrolling_array2.js' type=text/javascript></SCRIPT>\n" +
                    "<SCRIPT language=JavaScript src='../menues/menu_array.js' type=text/javascript></SCRIPT>\n" +
                    "<!--<SCRIPT language=JavaScript src='../menues/menu2_array.js' type=text/javascript></SCRIPT>-->\n" +
                    "<SCRIPT language=JavaScript src='../menues/lineahalf_array.js' type=text/javascript></SCRIPT>\n" +
                    "<SCRIPT language=JavaScript src='../menues/mmenu.js' type=text/javascript></SCRIPT>\n" +
                    "<!--<SCRIPT LANGUAGE='JavaScript1.2' SRC='../menues/topmenu.js'></SCRIPT>-->\n" +
                    "\n" +
                    "</HEAD>\n" +
                    "\n" +
                    "<BODY topmargin=0 leftmargin=0 BGPROPERTIES='FIXED' TEXT=7E6B46 BGCOLOR=FFE2A9 LINK=7E6B46 VLINK=7E6B46>\n" +
                    "\n" +
                    "<center>\n" +
                    "\n" +
                    "<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0 WIDTH=100% BGCOLOR=000000>\n" +
                    "<TR><TD WIDTH=100 rowspan=2 HEIGTH=62>\n" +
                    "\t<OBJECT classid=clsid:D27CDB6E-AE6D-11cf-96B8-444553540000 codebase=http://active.macromedia.com/flash2/cabs/swflash.cab#version=4,0,0,0 ID=logo WIDTH=100 HEIGHT=62><PARAM NAME=movie VALUE=http://www.iskcon.com.mx/java/logo.swf><PARAM NAME=quality VALUE=high><PARAM NAME=bgcolor VALUE=000000><EMBED src=http://www.iskcon.com.mx/java/logo.swf quality=high bgcolor=000000 WIDTH=100 HEIGHT=62 TYPE=application/x-shockwave-flash PLUGINSPAGE=http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash></EMBED></OBJECT>\n" +
                    "</TD><TD VALIGN=TOP WIDTH=500 colspan=5>\n" +
                    "\t<FONT COLOR=000000>.\n" +
                    "</TD></TR><tr><td valign=bottom>\n" +
                    "\t<center><font color=ffffff>\n" +
                    "\t<a href='print_cal.php?CIID=398&month=07&year=2016&lang=en'><img src=print.gif border=0 alt='Printable version'> \n" +
                    "\t<b>Printable version</b></a>\n" +
                    "</td><td valign=bottom>\n" +
                    "\t<a href='javascript:;' onClick=window.open('/help_en.php','_blank','width=500,height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false>\n" +
                    "\t<img src=help.gif border=0 alt='Online Help'> \n" +
                    "\t<b>Online Help</b></a>\n" +
                    "</td><td valign=bottom>\n" +
                    "\t<center>\n" +
                    "\t<a href='/facebook/?lang=en'><img src=/facebook.gif border=0 alt='Facebook'> \n" +
                    "\t<b>Facebook</b></a>\n" +
                    "</td><td valign=bottom>\n" +
                    "\t<center><font color=ffffff>\n" +
                    "\t<a href='vcal.php?CIID=398&lang=en&month=06&year=2016'><img src=previous.gif border=0 alt='Prev Month'> \n" +
                    "\t<b>Prev Month</b></a>\n" +
                    "</td><td valign=bottom>\n" +
                    "\t<center><font color=ffffff>\n" +
                    "\t<a href='vcal.php?CIID=398&lang=en&month=08&year=2016'><img src=next.gif border=0 alt='Next Month'> \n" +
                    "\t<b>Next Month</b></a>\n" +
                    "</td><!--<td valign=bottom>\n" +
                    "\t<center><font color=ffffff>\n" +
                    "\t<a href='ics.php?CIID=398&month=07&year=2016&lang=en'><img src=ics.gif border=0 alt='For your PC or Mobile'> \n" +
                    "\t<b>LANG_MENU_ICS</b></a>\n" +
                    "</td>--></tr>\n" +
                    "</TABLE>\n" +
                    "\n" +
                    "\n" +
                    "<TABLE BORDER=0 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>\n" +
                    "<TR><td valign=bottom>\n" +
                    "\t<center>\n" +
                    "\t<img src=title_en.jpg><br>\n" +
                    "\tJuly 2016<br>San Jose, California, USA (121W57 37N22, Time zone = -8.00)\n" +
                    "</td><td valign=top>\n" +
                    "        <center>\n" +
                    "        <table border=0 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>\n" +
                    "        <tr><td valign=bottom>\n" +
                    "\t\t<SCRIPT LANGUAGE='JavaScript'>\n" +
                    "\t\t<!--\n" +
                    "\t\tfunction nav2Handler(list){\n" +
                    "\t\twindow.location.href = list.options[list.selectedIndex].value; }\n" +
                    "\t\t// -->\n" +
                    "\t\t</SCRIPT>\n" +
                    "\t\t<FORM name =  'nav2'>\n" +
                    "\t\t<SELECT NAME='site' SIZE=1 onChange ='nav2Handler(document.nav2.site)'>\n" +
                    "\t\t<OPTION VALUE='servicios.htm'>SELECT LANGUAGE:\n" +
                    "\t\t<OPTION VALUE='vcal.php?CIID=398&lang=en&month=07&year=2016'>English\n" +
                    "\t\t<OPTION VALUE='vcal.php?CIID=398&lang=es&month=07&year=2016'>Español\n" +
                    "\t\t<OPTION VALUE='vcal.php?CIID=398&lang=pt&month=07&year=2016'>Português\n" +
                    "\t\t</SELECT>\n" +
                    "\t\t</FORM>\n" +
                    "\t</td><td>\n" +
                    "\t\t<form>\n" +
                    "\t\t<select name=CIID onChange='return CheckCIIDSelect()' ID=CIID>\n" +
                    "      <option value=0>SELECT COUNTRY AND CITY:</option>\n" +
                    "      <option value='0' >ARGENTINA</option>\n" +
                    "      <option value='4' >....Bhaía Blanca</option>\n" +
                    "      <option value='5' >....Buenos Aires</option>\n" +
                    "      <option value='6' >....Córdoba</option>\n" +
                    "      <option value='7' >....Mar del Plata</option>\n" +
                    "      <option value='8' >....Mendoza</option>\n" +
                    "      <option value='9' >....Neuquén</option>\n" +
                    "      <option value='10' >....Río Ceballos</option>\n" +
                    "      <option value='11' >....Rosario</option>\n" +
                    "      <option value='12' >....San Juan</option>\n" +
                    "      <option value='504' >....San Luis</option>\n" +
                    "      <option value='0' >ARMENIA ( &#1344;&#1377;&#1397;&#1377;&#1405;&#1407;&#1377;&#1398; )</option>\n" +
                    "      <option value='3' >....Yerevan</option>\n" +
                    "      <option value='0' >AUSTRALIA</option>\n" +
                    "      <option value='13' >....Adelaide</option>\n" +
                    "      <option value='14' >....Bambra - Victoria</option>\n" +
                    "      <option value='15' >....Brisbane</option>\n" +
                    "      <option value='16' >....Cairns</option>\n" +
                    "      <option value='17' >....Canberra</option>\n" +
                    "      <option value='18' >....Cessnocknsw</option>\n" +
                    "      <option value='493' >....Darwin</option>\n" +
                    "      <option value='19' >....Lismore</option>\n" +
                    "      <option value='20' >....Melbourne</option>\n" +
                    "      <option value='21' >....Murwillumbah</option>\n" +
                    "      <option value='22' >....Perth</option>\n" +
                    "      <option value='23' >....Sydney</option>\n" +
                    "      <option value='24' >....Winchelsea</option>\n" +
                    "      <option value='0' >AUSTRIA</option>\n" +
                    "      <option value='25' >....Graz</option>\n" +
                    "      <option value='26' >....Klagenfurt</option>\n" +
                    "      <option value='27' >....Salzburg</option>\n" +
                    "      <option value='28' >....St Aegyd</option>\n" +
                    "      <option value='29' >....Vienna</option>\n" +
                    "      <option value='0' >AZERBAIJAN ( AZ&#601;RBAYCAN )</option>\n" +
                    "      <option value='30' >....Baku</option>\n" +
                    "      <option value='0' >BAHRAIN ( &#8207;&#1575;&#1604;&#1576;&#1581;&#1585;&#1610;&#1606;&#8206; )</option>\n" +
                    "      <option value='31' >....Manama</option>\n" +
                    "      <option value='0' >BANGLADESH ( &#2476;&#2494;&#2434;&#2482;&#2494;&#2470;&#2503;&#2486; )</option>\n" +
                    "      <option value='32' >....Cittagong</option>\n" +
                    "      <option value='33' >....Dhaka</option>\n" +
                    "      <option value='34' >....Jessore</option>\n" +
                    "      <option value='0' >BARBADOS</option>\n" +
                    "      <option value='35' >....Barbados</option>\n" +
                    "      <option value='0' >BELARUS ( &#1041;&#1077;&#1083;&#1072;&#1088;&#1091;&#769;&#1089;&#1100; )</option>\n" +
                    "      <option value='36' >....Minsk</option>\n" +
                    "      <option value='0' >BELGIQUE</option>\n" +
                    "      <option value='37' >....Antwerp</option>\n" +
                    "      <option value='38' >....Brussels</option>\n" +
                    "      <option value='39' >....Durbuy</option>\n" +
                    "      <option value='40' >....Liege</option>\n" +
                    "      <option value='0' >BOLIVIA</option>\n" +
                    "      <option value='41' >....Cochabamba</option>\n" +
                    "      <option value='42' >....La Paz</option>\n" +
                    "      <option value='43' >....Santa Cruz</option>\n" +
                    "      <option value='0' >BOSNIA AND HERZEGOWINA ( &#1041;&#1086;&#1089;&#1085;A &#1080; &#1061;&#1077;&#1088;&#1094;&#1077;&#1075;&#1086;&#1074;&#1080;&#1085;&#1072; )</option>\n" +
                    "      <option value='44' >....Sarajevo</option>\n" +
                    "      <option value='0' >BOTSWANA</option>\n" +
                    "      <option value='478' >....Gaborone</option>\n" +
                    "      <option value='0' >BRASIL</option>\n" +
                    "      <option value='481' >....Areado</option>\n" +
                    "      <option value='45' >....Belem</option>\n" +
                    "      <option value='46' >....Belo Horizonte</option>\n" +
                    "      <option value='47' >....Brasilia</option>\n" +
                    "      <option value='48' >....Campos</option>\n" +
                    "      <option value='49' >....Caruaru</option>\n" +
                    "      <option value='50' >....Curitiba</option>\n" +
                    "      <option value='51' >....Florianopolis</option>\n" +
                    "      <option value='52' >....Fortaleza</option>\n" +
                    "      <option value='53' >....Goiania</option>\n" +
                    "      <option value='54' >....Guarulhos</option>\n" +
                    "      <option value='56' >....Juiz de Foa</option>\n" +
                    "      <option value='57' >....Jundiaí</option>\n" +
                    "      <option value='58' >....Lambari</option>\n" +
                    "      <option value='59' >....Manaus</option>\n" +
                    "      <option value='495' >....Nova Gokula</option>\n" +
                    "      <option value='60' >....Petropolis</option>\n" +
                    "      <option value='61' >....Porto Alegre</option>\n" +
                    "      <option value='62' >....Recife</option>\n" +
                    "      <option value='63' >....Ribeirao Preto</option>\n" +
                    "      <option value='64' >....Rio de Janeiro</option>\n" +
                    "      <option value='65' >....Salvador</option>\n" +
                    "      <option value='66' >....Santos</option>\n" +
                    "      <option value='67' >....São Carlos</option>\n" +
                    "      <option value='55' >....São José do Rio Preto</option>\n" +
                    "      <option value='68' >....São Paulo</option>\n" +
                    "      <option value='511' >....Suzano</option>\n" +
                    "      <option value='69' >....Taubate</option>\n" +
                    "      <option value='70' >....Ubatuba</option>\n" +
                    "      <option value='71' >....Vitoria</option>\n" +
                    "      <option value='0' >BULGARIYA</option>\n" +
                    "      <option value='72' >....Plovdiv</option>\n" +
                    "      <option value='73' >....Sofía</option>\n" +
                    "      <option value='0' >CAMEROUN</option>\n" +
                    "      <option value='74' >....Buea</option>\n" +
                    "      <option value='0' >CANADA</option>\n" +
                    "      <option value='75' >....AL - Calgary</option>\n" +
                    "      <option value='76' >....AL - Edmonton</option>\n" +
                    "      <option value='77' >....BC - Ashcroft</option>\n" +
                    "      <option value='78' >....BC - Vancouver</option>\n" +
                    "      <option value='81' >....NF - Placentia</option>\n" +
                    "      <option value='79' >....ON - Ottawa</option>\n" +
                    "      <option value='80' >....ON - Toronto</option>\n" +
                    "      <option value='83' >....QC - Montreal</option>\n" +
                    "      <option value='82' >....QC - Québec</option>\n" +
                    "      <option value='84' >....SK - Regina</option>\n" +
                    "      <option value='85' >....VC - Victoria</option>\n" +
                    "      <option value='0' >CHINA ( &#20013;&#22283; )</option>\n" +
                    "      <option value='88' >....Beijing</option>\n" +
                    "      <option value='89' >....Hong Kong</option>\n" +
                    "      <option value='494' >....Shangai</option>\n" +
                    "      <option value='365' >....Taipei</option>\n" +
                    "      <option value='0' >CHLE</option>\n" +
                    "      <option value='86' >....Concepción</option>\n" +
                    "      <option value='518' >....Pucon</option>\n" +
                    "      <option value='87' >....Santiago</option>\n" +
                    "      <option value='0' >COLOMBIA</option>\n" +
                    "      <option value='457' >....Barranquilla</option>\n" +
                    "      <option value='90' >....Bogotá</option>\n" +
                    "      <option value='91' >....Cali</option>\n" +
                    "      <option value='524' >....Medellin</option>\n" +
                    "      <option value='92' >....Pereira</option>\n" +
                    "      <option value='0' >COOK ISLANDS</option>\n" +
                    "      <option value='499' >....Rarotonga</option>\n" +
                    "      <option value='0' >COSTA RICA</option>\n" +
                    "      <option value='93' >....San José</option>\n" +
                    "      <option value='0' >CÔTE D IVORE</option>\n" +
                    "      <option value='233' >....Abidjan</option>\n" +
                    "      <option value='0' >CROATIA (HRVARSKA)</option>\n" +
                    "      <option value='94' >....Osijek</option>\n" +
                    "      <option value='95' >....Pula</option>\n" +
                    "      <option value='96' >....Rijeka</option>\n" +
                    "      <option value='97' >....Split</option>\n" +
                    "      <option value='98' >....Zagreb</option>\n" +
                    "      <option value='0' >CUBA</option>\n" +
                    "      <option value='99' >....La Habana</option>\n" +
                    "      <option value='0' >CYPRUS (KIBRIS)</option>\n" +
                    "      <option value='100' >....Cyprus</option>\n" +
                    "      <option value='0' >CZECH REPUBLIC ( &#268;ESKÁ )</option>\n" +
                    "      <option value='101' >....Prague</option>\n" +
                    "      <option value='102' >....Zlin</option>\n" +
                    "      <option value='0' >DANMARK</option>\n" +
                    "      <option value='103' >....Brorup</option>\n" +
                    "      <option value='104' >....Copenhagen</option>\n" +
                    "      <option value='0' >ECUADOR</option>\n" +
                    "      <option value='106' >....Cuenca</option>\n" +
                    "      <option value='107' >....Guayaquil</option>\n" +
                    "      <option value='108' >....Quito</option>\n" +
                    "      <option value='0' >EL SALVADOR</option>\n" +
                    "      <option value='109' >....San Salvador</option>\n" +
                    "      <option value='0' >ESTONIA ( EESTI )</option>\n" +
                    "      <option value='110' >....Tallinn</option>\n" +
                    "      <option value='0' >FIJI</option>\n" +
                    "      <option value='111' >....Labasa</option>\n" +
                    "      <option value='112' >....Lautoka</option>\n" +
                    "      <option value='526' >....Sigatoga</option>\n" +
                    "      <option value='113' >....Suva</option>\n" +
                    "      <option value='0' >FINLAND ( SUOMI )</option>\n" +
                    "      <option value='114' >....Helsinki</option>\n" +
                    "      <option value='115' >....Tampere</option>\n" +
                    "      <option value='116' >....Turku</option>\n" +
                    "      <option value='0' >FRANÇAISE</option>\n" +
                    "      <option value='117' >....Avignon</option>\n" +
                    "      <option value='118' >....Bordeaux</option>\n" +
                    "      <option value='119' >....Brest</option>\n" +
                    "      <option value='120' >....Chateauroux</option>\n" +
                    "      <option value='121' >....Dijón</option>\n" +
                    "      <option value='122' >....Dole</option>\n" +
                    "      <option value='123' >....Lille</option>\n" +
                    "      <option value='124' >....Longwy</option>\n" +
                    "      <option value='125' >....Lyon</option>\n" +
                    "      <option value='126' >....Nice</option>\n" +
                    "      <option value='127' >....Orange</option>\n" +
                    "      <option value='128' >....Paris</option>\n" +
                    "      <option value='129' >....Poitiers</option>\n" +
                    "      <option value='130' >....Toulous</option>\n" +
                    "      <option value='131' >....Valencay</option>\n" +
                    "      <option value='0' >GEORGIA ( &#4321;&#4304;&#4325;&#4304;&#4320;&#4311;&#4309;&#4308;&#4314;&#4317; )</option>\n" +
                    "      <option value='132' >....Tbilisi</option>\n" +
                    "      <option value='0' >GERMANY ( DEUTSCHLAND )</option>\n" +
                    "      <option value='133' >....Berlin</option>\n" +
                    "      <option value='134' >....Bremerhaven</option>\n" +
                    "      <option value='135' >....Dresden</option>\n" +
                    "      <option value='136' >....Flensburg</option>\n" +
                    "      <option value='137' >....Frankfurt</option>\n" +
                    "      <option value='139' >....Hamburg</option>\n" +
                    "      <option value='140' >....Hannover</option>\n" +
                    "      <option value='141' >....Heidelberg</option>\n" +
                    "      <option value='142' >....Heilbronn</option>\n" +
                    "      <option value='143' >....Karlsruhe</option>\n" +
                    "      <option value='144' >....Kiel</option>\n" +
                    "      <option value='145' >....Koblenz</option>\n" +
                    "      <option value='146' >....Köln (Cologne)</option>\n" +
                    "      <option value='147' >....Leipzig</option>\n" +
                    "      <option value='148' >....Marburg</option>\n" +
                    "      <option value='149' >....München (Munich)</option>\n" +
                    "      <option value='150' >....Nurnberg (Nuremberg)</option>\n" +
                    "      <option value='151' >....Paderborn</option>\n" +
                    "      <option value='152' >....Passau</option>\n" +
                    "      <option value='153' >....Saarbrucken</option>\n" +
                    "      <option value='154' >....Salzwedel</option>\n" +
                    "      <option value='155' >....Schwerin</option>\n" +
                    "      <option value='466' >....Simhachalam</option>\n" +
                    "      <option value='156' >....Stuttgart</option>\n" +
                    "      <option value='157' >....Trier</option>\n" +
                    "      <option value='158' >....Ulm</option>\n" +
                    "      <option value='482' >....Ummern</option>\n" +
                    "      <option value='159' >....Weimar</option>\n" +
                    "      <option value='160' >....Wiesbaden</option>\n" +
                    "      <option value='0' >GHANA</option>\n" +
                    "      <option value='161' >....Accra</option>\n" +
                    "      <option value='162' >....Nkawkaw</option>\n" +
                    "      <option value='163' >....Takoradi</option>\n" +
                    "      <option value='0' >GRECE ( &#917;&#955;&#955;&#940;&#962; )</option>\n" +
                    "      <option value='164' >....Athens</option>\n" +
                    "      <option value='0' >GUATEMALA</option>\n" +
                    "      <option value='165' >....Guatemala</option>\n" +
                    "      <option value='0' >GUYANA</option>\n" +
                    "      <option value='166' >....Berbice</option>\n" +
                    "      <option value='167' >....Essequibo Coast</option>\n" +
                    "      <option value='168' >....Georgetown</option>\n" +
                    "      <option value='0' >HONDURAS</option>\n" +
                    "      <option value='169' >....Tegucigalpa</option>\n" +
                    "      <option value='0' >HUNGARY ( MAGYARORSZÁG )</option>\n" +
                    "      <option value='170' >....Budapest</option>\n" +
                    "      <option value='171' >....Debrecen</option>\n" +
                    "      <option value='172' >....Kaposvar</option>\n" +
                    "      <option value='173' >....Szolnok</option>\n" +
                    "      <option value='0' >ICELAND</option>\n" +
                    "      <option value='174' >....Reykjavik</option>\n" +
                    "      <option value='0' >INDIA ( &#2349;&#2366;&#2352;&#2340; )</option>\n" +
                    "      <option value='175' >....AP - Guntur</option>\n" +
                    "      <option value='176' >....AP - Hyderabad</option>\n" +
                    "      <option value='177' >....AP - Secunderabad</option>\n" +
                    "      <option value='178' >....AP - Tirupati</option>\n" +
                    "      <option value='179' >....AS - Guwahati</option>\n" +
                    "      <option value='180' >....AS - Silchar</option>\n" +
                    "      <option value='181' >....BI - Patna</option>\n" +
                    "      <option value='182' >....CH - Chandigarh</option>\n" +
                    "      <option value='183' >....GU - Ahmedabad</option>\n" +
                    "      <option value='473' >....GU - Anand</option>\n" +
                    "      <option value='184' >....GU - Dwaraka</option>\n" +
                    "      <option value='185' >....GU - Surat</option>\n" +
                    "      <option value='186' >....GU - Vadodara (Baroda)</option>\n" +
                    "      <option value='475' >....GU - Vallabh Vidyanagar</option>\n" +
                    "      <option value='497' >....HY - Faridabad</option>\n" +
                    "      <option value='187' >....JK - Udhampur</option>\n" +
                    "      <option value='188' >....KA - Bangalore</option>\n" +
                    "      <option value='189' >....KA - Belgaum</option>\n" +
                    "      <option value='190' >....KA - Mangalore</option>\n" +
                    "      <option value='517' >....KE - Kozhikode</option>\n" +
                    "      <option value='191' >....KE - Thiruvananthapuram</option>\n" +
                    "      <option value='192' >....KE - Trivandrum</option>\n" +
                    "      <option value='198' >....MA - Imphal</option>\n" +
                    "      <option value='199' >....MA - Moirang</option>\n" +
                    "      <option value='467' >....MP - Ujjain</option>\n" +
                    "      <option value='193' >....MR - Aurangabad</option>\n" +
                    "      <option value='194' >....MR - Mumbai (Bombay)</option>\n" +
                    "      <option value='195' >....MR - Nagpur</option>\n" +
                    "      <option value='196' >....MR - Pandharpur</option>\n" +
                    "      <option value='197' >....MR - Pune</option>\n" +
                    "      <option value='200' >....ND - New Delhi</option>\n" +
                    "      <option value='201' >....OR - Bhubaneswar</option>\n" +
                    "      <option value='202' >....OR - Puri</option>\n" +
                    "      <option value='505' >....OR - Rourkela</option>\n" +
                    "      <option value='480' >....PU - Amristar</option>\n" +
                    "      <option value='472' >....PU - Jalandhar</option>\n" +
                    "      <option value='471' >....PU - Ludiana</option>\n" +
                    "      <option value='203' >....RA - Jaipur</option>\n" +
                    "      <option value='205' >....TN - Chennai (Madras)</option>\n" +
                    "      <option value='204' >....TN - Coimbatore</option>\n" +
                    "      <option value='206' >....TN - Srirangam</option>\n" +
                    "      <option value='207' >....TR - Agartala</option>\n" +
                    "      <option value='208' >....UP - Allahabad</option>\n" +
                    "      <option value='209' >....UP - Hardwar</option>\n" +
                    "      <option value='210' >....UP - Lucknow</option>\n" +
                    "      <option value='211' >....UP - Mathura</option>\n" +
                    "      <option value='509' >....UP - Meerut</option>\n" +
                    "      <option value='212' >....UP - Vrindavan</option>\n" +
                    "      <option value='213' >....WB - Calcutta</option>\n" +
                    "      <option value='214' >....WB - Mayapur</option>\n" +
                    "      <option value='215' >....WB - Navadwip</option>\n" +
                    "      <option value='216' >....WB - Siliguri</option>\n" +
                    "      <option value='0' >INDONESIA</option>\n" +
                    "      <option value='217' >....Bali</option>\n" +
                    "      <option value='218' >....Bogor</option>\n" +
                    "      <option value='219' >....Denpasar</option>\n" +
                    "      <option value='220' >....Jakarta</option>\n" +
                    "      <option value='453' >....Jogjakarta</option>\n" +
                    "      <option value='0' >IRAN ( &#1575;&#1740;&#1585;&#1575;&#1606; )</option>\n" +
                    "      <option value='221' >....Teheran</option>\n" +
                    "      <option value='0' >IRELAND (IRISH)</option>\n" +
                    "      <option value='374' >....Dublin</option>\n" +
                    "      <option value='383' >....Wexford</option>\n" +
                    "      <option value='0' >IRELAND N ( ÉIRE )</option>\n" +
                    "      <option value='285' >....Belfast</option>\n" +
                    "      <option value='286' >....Derrylin</option>\n" +
                    "      <option value='0' >ISRAEL ( &#1497;&#1460;&#1513;&#1456;&#1474;&#1512;&#1464;&#1488;&#1461;&#1500; )</option>\n" +
                    "      <option value='222' >....Telaviv</option>\n" +
                    "      <option value='0' >ITALIA</option>\n" +
                    "      <option value='223' >....Bergamo</option>\n" +
                    "      <option value='224' >....Bologna</option>\n" +
                    "      <option value='225' >....Catania</option>\n" +
                    "      <option value='226' >....Firenze (Florence)</option>\n" +
                    "      <option value='227' >....Milán</option>\n" +
                    "      <option value='228' >....Naples (Napoli)</option>\n" +
                    "      <option value='229' >....Padua</option>\n" +
                    "      <option value='230' >....Pisa</option>\n" +
                    "      <option value='231' >....Rome</option>\n" +
                    "      <option value='488' >....Verona</option>\n" +
                    "      <option value='232' >....Vicenza</option>\n" +
                    "      <option value='0' >JAPAN ( &#26085;&#26412;&#22269; )</option>\n" +
                    "      <option value='234' >....Okinawa</option>\n" +
                    "      <option value='235' >....Sapporo</option>\n" +
                    "      <option value='236' >....Tokyo</option>\n" +
                    "      <option value='0' >KAZAKHSTAN ( &#1178;&#1072;&#1079;&#1072;&#1179;&#1089;&#1090;&#1072;&#1085; )</option>\n" +
                    "      <option value='237' >....Alma-ata</option>\n" +
                    "      <option value='0' >KENYA</option>\n" +
                    "      <option value='238' >....Kisumu</option>\n" +
                    "      <option value='239' >....Mombasa</option>\n" +
                    "      <option value='240' >....Nairobi</option>\n" +
                    "      <option value='0' >KUWAIT ( &#1583;&#1608;&#1604;&#1577; &#1575;&#1604;&#1603;&#1608;&#1610;&#1578; )</option>\n" +
                    "      <option value='474' >....Kuwait</option>\n" +
                    "      <option value='0' >LATVIJA</option>\n" +
                    "      <option value='241' >....Riga</option>\n" +
                    "      <option value='0' >LITHUANIA ( LIETUVA )</option>\n" +
                    "      <option value='242' >....Alytus</option>\n" +
                    "      <option value='243' >....Druskininkai</option>\n" +
                    "      <option value='244' >....Kaunas</option>\n" +
                    "      <option value='245' >....Klaipeda</option>\n" +
                    "      <option value='246' >....Mazheikiai</option>\n" +
                    "      <option value='247' >....Panevezhys</option>\n" +
                    "      <option value='248' >....Shyaulyai</option>\n" +
                    "      <option value='249' >....Utena</option>\n" +
                    "      <option value='250' >....Vilnius</option>\n" +
                    "      <option value='0' >MACEDONIA ( &#1052;&#1072;&#1082;&#1077;&#1076;&#1086;&#1085;&#1080;&#1112;&#1072; )</option>\n" +
                    "      <option value='506' >....Skopje</option>\n" +
                    "      <option value='0' >MALAYSIA</option>\n" +
                    "      <option value='251' >....Bukit Mertajam</option>\n" +
                    "      <option value='252' >....Ipoh</option>\n" +
                    "      <option value='253' >....Kuala Lumpur</option>\n" +
                    "      <option value='254' >....Perak</option>\n" +
                    "      <option value='0' >MAURITIUS</option>\n" +
                    "      <option value='255' >....Mauritius</option>\n" +
                    "      <option value='0' >MÉXICO</option>\n" +
                    "      <option value='256' >....Cancún</option>\n" +
                    "      <option value='523' >....Colima</option>\n" +
                    "      <option value='257' >....Culiacán</option>\n" +
                    "      <option value='507' >....Durango</option>\n" +
                    "      <option value='258' >....Guadalajara</option>\n" +
                    "      <option value='259' >....León</option>\n" +
                    "      <option value='260' >....Loreto</option>\n" +
                    "      <option value='261' >....Mexico City</option>\n" +
                    "      <option value='262' >....Monterrey</option>\n" +
                    "      <option value='263' >....Morelia</option>\n" +
                    "      <option value='483' >....Pachuca</option>\n" +
                    "      <option value='264' >....Saltillo</option>\n" +
                    "      <option value='484' >....San Luis Potosí</option>\n" +
                    "      <option value='265' >....Tijuana</option>\n" +
                    "      <option value='500' >....Torreón</option>\n" +
                    "      <option value='266' >....Tulancingo</option>\n" +
                    "      <option value='267' >....Veracruz</option>\n" +
                    "      <option value='268' >....Villahermosa</option>\n" +
                    "      <option value='0' >NEPAL</option>\n" +
                    "      <option value='269' >....Kathmandu</option>\n" +
                    "      <option value='0' >NETHERLANDS (NEDERLANDEN)</option>\n" +
                    "      <option value='270' >....Amsterdam</option>\n" +
                    "      <option value='460' >....Den Haag</option>\n" +
                    "      <option value='271' >....Utrecht</option>\n" +
                    "      <option value='0' >NEW ZEALAND ( AOTEAROA )</option>\n" +
                    "      <option value='272' >....Auckland</option>\n" +
                    "      <option value='273' >....Christchurch</option>\n" +
                    "      <option value='508' >....Hamilton</option>\n" +
                    "      <option value='274' >....Wellington</option>\n" +
                    "      <option value='0' >NICARAGUA</option>\n" +
                    "      <option value='275' >....Chinandega</option>\n" +
                    "      <option value='276' >....Managua</option>\n" +
                    "      <option value='0' >NIGERIA</option>\n" +
                    "      <option value='277' >....Abeokuta</option>\n" +
                    "      <option value='278' >....Benin City</option>\n" +
                    "      <option value='279' >....Enugu</option>\n" +
                    "      <option value='280' >....Ibadan</option>\n" +
                    "      <option value='281' >....Kaduna</option>\n" +
                    "      <option value='282' >....Lagos</option>\n" +
                    "      <option value='283' >....Porth Arcourt</option>\n" +
                    "      <option value='284' >....Warri</option>\n" +
                    "      <option value='0' >NORWAY ( NORGE )</option>\n" +
                    "      <option value='287' >....Bergen</option>\n" +
                    "      <option value='288' >....Oslo</option>\n" +
                    "      <option value='0' >PAKISTAN ( &#1662;&#1575;&#1603;&#1587;&#1578;&#1575;&#1606;&#8206; )</option>\n" +
                    "      <option value='492' >....Karachi</option>\n" +
                    "      <option value='0' >PANAMÁ</option>\n" +
                    "      <option value='289' >....Panamá</option>\n" +
                    "      <option value='0' >PAPUA NEW GUINEA ( PAPUA NIUGINI )</option>\n" +
                    "      <option value='290' >....Port Morseby</option>\n" +
                    "      <option value='0' >PARAGUAY</option>\n" +
                    "      <option value='291' >....Asunción</option>\n" +
                    "      <option value='0' >PERÚ</option>\n" +
                    "      <option value='292' >....Arequipa</option>\n" +
                    "      <option value='498' >....Chiclayo</option>\n" +
                    "      <option value='293' >....Cuzco</option>\n" +
                    "      <option value='513' >....Huancayo</option>\n" +
                    "      <option value='514' >....Huanuco</option>\n" +
                    "      <option value='476' >....Ica</option>\n" +
                    "      <option value='294' >....Iquitos</option>\n" +
                    "      <option value='295' >....Lima</option>\n" +
                    "      <option value='459' >....Neuquén</option>\n" +
                    "      <option value='296' >....Puno</option>\n" +
                    "      <option value='297' >....Salcabamba</option>\n" +
                    "      <option value='515' >....Satipo</option>\n" +
                    "      <option value='298' >....Tarapoto</option>\n" +
                    "      <option value='516' >....Trujillo</option>\n" +
                    "      <option value='0' >PHILIPPINES ( PILIPINAS )</option>\n" +
                    "      <option value='299' >....Cagayan</option>\n" +
                    "      <option value='300' >....Cebu</option>\n" +
                    "      <option value='301' >....Iloilo</option>\n" +
                    "      <option value='302' >....Manila</option>\n" +
                    "      <option value='0' >POLAND ( POLSKA )</option>\n" +
                    "      <option value='303' >....Gdansk</option>\n" +
                    "      <option value='304' >....Gorzow</option>\n" +
                    "      <option value='305' >....Warsaw</option>\n" +
                    "      <option value='306' >....Wroclaw</option>\n" +
                    "      <option value='0' >PORTUGAL</option>\n" +
                    "      <option value='307' >....Lisboa</option>\n" +
                    "      <option value='308' >....Oporto</option>\n" +
                    "      <option value='0' >REPUBLICA DOMINICANA</option>\n" +
                    "      <option value='105' >....Santo Domingo</option>\n" +
                    "      <option value='0' >ROMÂNIA</option>\n" +
                    "      <option value='309' >....Bucharest</option>\n" +
                    "      <option value='310' >....Timisoara</option>\n" +
                    "      <option value='0' >RUSSIA ( &#1056;&#1086;&#1089;&#1089;&#1080;&#1103; )</option>\n" +
                    "      <option value='311' >....Ekaterinburg</option>\n" +
                    "      <option value='312' >....Krasnoyarsk</option>\n" +
                    "      <option value='313' >....Moscow</option>\n" +
                    "      <option value='314' >....Novosibirsk</option>\n" +
                    "      <option value='315' >....St Petersburg</option>\n" +
                    "      <option value='316' >....Vladikavkaz</option>\n" +
                    "      <option value='317' >....Vladivostok</option>\n" +
                    "      <option value='0' >SAUDI ARABIA ( &#1575;&#1604;&#1605;&#1605;&#1604;&#1603;&#1577; &#1575;&#1604;&#1593;&#1585;&#1576;&#1610;&#1577; &#1575;&#1604;&#1587;&#1593;&#1608;&#1583;&#1610;&#1577; )</option>\n" +
                    "      <option value='522' >....Damman ( &#1575;&#1604;&#1583;&#1605;&#1575;&#1605;&#8206; )</option>\n" +
                    "      <option value='521' >....Jeddah ( &#1580;&#1583;&#1617;&#1577; )</option>\n" +
                    "      <option value='520' >....Riyadh ( &#1604;&#1585;&#1610;&#1575;&#1590;&#8206; )</option>\n" +
                    "      <option value='0' >SERBIA ( &#1057;&#1088;&#1073;&#1080;&#1112;&#1072; )</option>\n" +
                    "      <option value='318' >....Belgrade</option>\n" +
                    "      <option value='319' >....Sombor</option>\n" +
                    "      <option value='0' >SEYCHELLES ( SESEL )</option>\n" +
                    "      <option value='465' >....Victoria</option>\n" +
                    "      <option value='0' >SIERRA LEONE</option>\n" +
                    "      <option value='320' >....Freetown</option>\n" +
                    "      <option value='0' >SINGAPORE</option>\n" +
                    "      <option value='321' >....Singapore</option>\n" +
                    "      <option value='0' >SLOVAK REPUBLIC ( SLOVENSKÁ )</option>\n" +
                    "      <option value='322' >....Bratislava</option>\n" +
                    "      <option value='479' >....Nova Ekacakra</option>\n" +
                    "      <option value='323' >....Trnava</option>\n" +
                    "      <option value='0' >SLOVENIA ( SLOVENIJA )</option>\n" +
                    "      <option value='324' >....Ljubljana</option>\n" +
                    "      <option value='0' >SOUTH AFRICA</option>\n" +
                    "      <option value='325' >....Cape Town</option>\n" +
                    "      <option value='326' >....Durban</option>\n" +
                    "      <option value='327' >....Johannesburg</option>\n" +
                    "      <option value='328' >....Port Elizabeth</option>\n" +
                    "      <option value='0' >SOUTH COREA ( &#45824;&#54620;&#48124;&#44397; )</option>\n" +
                    "      <option value='519' >....Seoul</option>\n" +
                    "      <option value='0' >SPAIN (ESPAÑA)</option>\n" +
                    "      <option value='329' >....Barcelona</option>\n" +
                    "      <option value='330' >....Brihuega</option>\n" +
                    "      <option value='331' >....Galicia</option>\n" +
                    "      <option value='458' >....Guadalajara</option>\n" +
                    "      <option value='332' >....Is. Canarias</option>\n" +
                    "      <option value='334' >....Madrid</option>\n" +
                    "      <option value='335' >....Málaga</option>\n" +
                    "      <option value='336' >....Santa Cruz de Tenerife</option>\n" +
                    "      <option value='337' >....Valencia</option>\n" +
                    "      <option value='0' >SRI LANKA ( &#2965;&#3009;&#2975;&#3007;&#2991;&#2992;&#2970;&#3009; )</option>\n" +
                    "      <option value='338' >....Colombo</option>\n" +
                    "      <option value='0' >SURINAME</option>\n" +
                    "      <option value='491' >....Nieuw Nickerie</option>\n" +
                    "      <option value='339' >....Paramaribo</option>\n" +
                    "      <option value='0' >SWEDEN ( SVERIGE )</option>\n" +
                    "      <option value='340' >....Avesta</option>\n" +
                    "      <option value='341' >....Gothenburg</option>\n" +
                    "      <option value='343' >....Haparanda</option>\n" +
                    "      <option value='344' >....Horby</option>\n" +
                    "      <option value='345' >....Jonkoping</option>\n" +
                    "      <option value='346' >....Karlstad</option>\n" +
                    "      <option value='347' >....Ludvika</option>\n" +
                    "      <option value='348' >....Lulea</option>\n" +
                    "      <option value='349' >....Lund</option>\n" +
                    "      <option value='350' >....Mälmo</option>\n" +
                    "      <option value='351' >....Stockholm</option>\n" +
                    "      <option value='352' >....Sundsvall</option>\n" +
                    "      <option value='353' >....Umea</option>\n" +
                    "      <option value='354' >....Uppsala</option>\n" +
                    "      <option value='355' >....Visby</option>\n" +
                    "      <option value='356' >....Östersund</option>\n" +
                    "      <option value='0' >SWITZERLAND ( SVIZRA )</option>\n" +
                    "      <option value='357' >....Basel</option>\n" +
                    "      <option value='358' >....Bern</option>\n" +
                    "      <option value='359' >....Düdingen</option>\n" +
                    "      <option value='360' >....Geneva</option>\n" +
                    "      <option value='361' >....Lugano</option>\n" +
                    "      <option value='362' >....Schaffhausen</option>\n" +
                    "      <option value='363' >....Zürich</option>\n" +
                    "      <option value='0' >SYRIA ( &#1587;&#1608;&#1585;&#1610;&#1575; )</option>\n" +
                    "      <option value='364' >....Al Quneitrah</option>\n" +
                    "      <option value='0' >THAILAND ( &#3611;&#3619;&#3632;&#3648;&#3607;&#3624;&#3652;&#3607;&#3618; )</option>\n" +
                    "      <option value='366' >....Bangkok</option>\n" +
                    "      <option value='0' >TRINIDAD AND TOBAGO</option>\n" +
                    "      <option value='367' >....Trinidad</option>\n" +
                    "      <option value='0' >TURKEY ( TÜRKIYE )</option>\n" +
                    "      <option value='454' >....Ankara</option>\n" +
                    "      <option value='455' >....Istambul</option>\n" +
                    "      <option value='456' >....Izhir</option>\n" +
                    "      <option value='0' >UGANDA</option>\n" +
                    "      <option value='368' >....Kampala</option>\n" +
                    "      <option value='0' >UKRAINE ( &#1059;&#1082;&#1088;&#1072;&#1111;&#1085;&#1072; )</option>\n" +
                    "      <option value='385' >....Kiev</option>\n" +
                    "      <option value='386' >....Odessa</option>\n" +
                    "      <option value='0' >UNITED ARAB EMIRATES ( &#1575;&#1604;&#1573;&#1605;&#1575;&#1585;&#1575;&#1578; &#1575;&#1604;&#1593;&#1585;&#1576;&#1610;&#1577; &#1575;&#1604;&#1605;&#1578;&#1581;&#1583;&#1577; )</option>\n" +
                    "      <option value='477' >....Abu Dhabi</option>\n" +
                    "      <option value='469' >....Dubai</option>\n" +
                    "      <option value='0' >UNITED KINGDOM</option>\n" +
                    "      <option value='369' >....Birmingham</option>\n" +
                    "      <option value='370' >....Bristol</option>\n" +
                    "      <option value='371' >....Cardiff</option>\n" +
                    "      <option value='372' >....Cleethorpes</option>\n" +
                    "      <option value='373' >....Coventry</option>\n" +
                    "      <option value='375' >....Glasgow</option>\n" +
                    "      <option value='501' >....Great Bricet</option>\n" +
                    "      <option value='376' >....Leicester</option>\n" +
                    "      <option value='377' >....Liverpool</option>\n" +
                    "      <option value='378' >....London</option>\n" +
                    "      <option value='379' >....Manchester</option>\n" +
                    "      <option value='380' >....New Castle</option>\n" +
                    "      <option value='381' >....Plymouth</option>\n" +
                    "      <option value='382' >....Romford</option>\n" +
                    "      <option value='384' >....Worcester</option>\n" +
                    "      <option value='0' >UNITED STATES</option>\n" +
                    "      <option value='389' >....AL - Juneau</option>\n" +
                    "      <option value='390' >....AZ - Phoenix</option>\n" +
                    "      <option value='391' >....AZ - Tucson</option>\n" +
                    "      <option value='503' >....CA  - Oakland</option>\n" +
                    "      <option value='392' >....CA - Arcata</option>\n" +
                    "      <option value='393' >....CA - Berkeley</option>\n" +
                    "      <option value='394' >....CA - Los Angeles</option>\n" +
                    "      <option value='395' >....CA - Palo Alto</option>\n" +
                    "      <option value='527' >....CA - Sacramento</option>\n" +
                    "      <option value='396' >....CA - San Diego</option>\n" +
                    "      <option value='397' >....CA - San Francisco</option>\n" +
                    "      <option value='398' selected>....CA - San Jose</option>\n" +
                    "      <option value='399' >....CA - San Luis Obispo</option>\n" +
                    "      <option value='400' >....CO - Boulder</option>\n" +
                    "      <option value='401' >....CO - Denver</option>\n" +
                    "      <option value='402' >....CT - Hartford</option>\n" +
                    "      <option value='403' >....DC - Washington</option>\n" +
                    "      <option value='404' >....FL - Gainesville</option>\n" +
                    "      <option value='405' >....FL - Key West</option>\n" +
                    "      <option value='406' >....FL - Miami</option>\n" +
                    "      <option value='407' >....FL - Tallahassee</option>\n" +
                    "      <option value='408' >....FL - Tampa</option>\n" +
                    "      <option value='409' >....GA - Atlanta</option>\n" +
                    "      <option value='410' >....HI - Hilo</option>\n" +
                    "      <option value='411' >....HI - Honolulu</option>\n" +
                    "      <option value='412' >....ID - Boise</option>\n" +
                    "      <option value='413' >....IL - Chicago</option>\n" +
                    "      <option value='502' >....IN - Indianapolis</option>\n" +
                    "      <option value='414' >....LA - New Orleans</option>\n" +
                    "      <option value='416' >....MA - Boston</option>\n" +
                    "      <option value='415' >....MD - Baltimore</option>\n" +
                    "      <option value='417' >....MI - Detroit</option>\n" +
                    "      <option value='418' >....MI - Lansing</option>\n" +
                    "      <option value='496' >....MN - Mineapolis</option>\n" +
                    "      <option value='420' >....MO - St Louis</option>\n" +
                    "      <option value='419' >....MS - Picayune</option>\n" +
                    "      <option value='424' >....NC - Chapelhill</option>\n" +
                    "      <option value='425' >....NC - Durham</option>\n" +
                    "      <option value='485' >....NC - Hillsborough</option>\n" +
                    "      <option value='426' >....NC - Winston-Salem</option>\n" +
                    "      <option value='421' >....NJ - Morristown</option>\n" +
                    "      <option value='422' >....NM - Alburquerque</option>\n" +
                    "      <option value='423' >....NY - New York</option>\n" +
                    "      <option value='470' >....NY - Syracuse</option>\n" +
                    "      <option value='427' >....OH - Cleveland</option>\n" +
                    "      <option value='428' >....OH - Columbus</option>\n" +
                    "      <option value='429' >....OK - Oklahoma City</option>\n" +
                    "      <option value='431' >....OR - Eugene</option>\n" +
                    "      <option value='430' >....OR - Portland</option>\n" +
                    "      <option value='432' >....PA - Gita-nagari Farm</option>\n" +
                    "      <option value='433' >....PA - Harrisburg</option>\n" +
                    "      <option value='434' >....PA - Philadelphia</option>\n" +
                    "      <option value='435' >....PA - Pittsburgh</option>\n" +
                    "      <option value='525' >....PA - Reading</option>\n" +
                    "      <option value='436' >....PR - Puerto Rico</option>\n" +
                    "      <option value='437' >....PR - San Juan</option>\n" +
                    "      <option value='438' >....SC - Charleston</option>\n" +
                    "      <option value='388' >....Territory - Virgin Islands</option>\n" +
                    "      <option value='439' >....TX - Austin</option>\n" +
                    "      <option value='440' >....TX - Dallas</option>\n" +
                    "      <option value='490' >....TX - Harlingen</option>\n" +
                    "      <option value='441' >....TX - Houston</option>\n" +
                    "      <option value='442' >....TX - Waco</option>\n" +
                    "      <option value='443' >....UT - Provo</option>\n" +
                    "      <option value='444' >....WS - Seattle</option>\n" +
                    "      <option value='445' >....WS - Walla Walla</option>\n" +
                    "      <option value='446' >....WV - Moundsville</option>\n" +
                    "      <option value='447' >....WV - New Vrindaban</option>\n" +
                    "      <option value='0' >URUGUAY</option>\n" +
                    "      <option value='387' >....Montevideo</option>\n" +
                    "      <option value='0' >UZBEKISTAN ( O&#699;ZBEKISTON )</option>\n" +
                    "      <option value='448' >....Tashkent</option>\n" +
                    "      <option value='0' >VENEZUELA</option>\n" +
                    "      <option value='449' >....Caracas</option>\n" +
                    "      <option value='0' >ZAMBIA</option>\n" +
                    "      <option value='450' >....Kitwe-nkana</option>\n" +
                    "      <option value='451' >....Lusaka</option>\n" +
                    "      <option value='0' >ZIMBABWE</option>\n" +
                    "      <option value='452' >....Harare</option></select>\n" +
                    "\t\t</form>\n" +
                    "\t</td><tr><tr><td colspan=2>\n" +
                    "\t\t<select name=code  onChange='return CheckSelectHoliday()' ID=code>\n" +
                    "      <option value=0>SEARCH FOR HOLIDAY:</option>\n" +
                    "      <option value='00080' >Gaura Purnima</option>\n" +
                    "      <option value='00082' >Nityananda Trayodasi</option>\n" +
                    "      <option value='00083' >Sri Krsna Janmastami</option>\n" +
                    "      <option value='00084' >Radhastami</option>\n" +
                    "      <option value='00085' >Appearance of Lord Balarama</option>\n" +
                    "      <option value='00087' >Rama Navami</option>\n" +
                    "      <option value='00088' >Nrsimha Caturdasi</option>\n" +
                    "      <option value='00089' >Sri Vamana Dvadasi</option>\n" +
                    "      <option value='00086' >Varaha Dvadasi</option>\n" +
                    "      <option value='' ></option>\n" +
                    "      <option value='00213' ><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=rathayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Ratha Yatra</a> (Jagannatha Puri)</option>\n" +
                    "      <option value='00225' ><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=jhulanayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Radha Govinda Jhulana Yatra begins</a></option>\n" +
                    "      <option value='00226' >Radha Govinda <a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=jhulanayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Jhulana Yatra ends</a></option>\n" +
                    "      <option value='A908' >Damodara Masa begin</option>\n" +
                    "      <option value='A909' >Damodara Masa ends</option>\n" +
                    "      <option value='00059' >Caturmasya begins</option>\n" +
                    "      <option value='00058' >Caturmasya ends</option>\n" +
                    "      <option value='00036' >Pandava Nirjala Ekadasi</option>\n" +
                    "      <option value='00201' ><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=govardhanapuja','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Govardhana Puja, Go Puja, Go Krda</a></option>\n" +
                    "      <option value='' ></option>\n" +
                    "      <option value='00090' >Sri Advaita Acarya Appearance</option>\n" +
                    "      <option value='00091' >Srila Gaura Kisora Dasa Babaji Dissappearance</option>\n" +
                    "      <option value='00092' >Srila Bhaktivinoda Thakura Appearance</option>\n" +
                    "      <option value='00093' >Srila Bhaktivinoda Thakura Dissappearance</option>\n" +
                    "      <option value='00095' >Srila Bhaktisiddhanta Sarasvati Thakura Appearance</option>\n" +
                    "      <option value='00094' >Srila Bhaktisiddhanta Sarasvati Thakura Dissappearance</option>\n" +
                    "      <option value='00096' >Srila Prabhupada Appearance</option>\n" +
                    "      <option value='00097' >Srila Prabhupada Dissappearance</option>\n" +
                    "      <option value='' ></option>\n" +
                    "      <option value='A028' >HH BB Govinda Svami Vyasa-puja</option>\n" +
                    "      <option value='A003' >HH Bhaktibusana Svami Vyasa-puja</option>\n" +
                    "      <option value='A049' >HH Bhakti Caitanya Svami Vyasa-puja</option>\n" +
                    "      <option value='A016' >HH Bhakti Caru Svami Vyasa-puja</option>\n" +
                    "      <option value='A055' >HH Bhakti Raghava Svami Vyasa-puja</option>\n" +
                    "      <option value='A026' >HH Bhaktisvarupa Damodar Svami Dissappearance</option>\n" +
                    "      <option value='A014' >HH Bhaktitirtha Svami Dissappearance</option>\n" +
                    "      <option value='A039' >HH Bir Krishna dasa Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A051' >HH Danavir Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A047' >HH Chandramukha Svami Vyasa-puja</option>\n" +
                    "      <option value='A051' >HH Danavir Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A005' >HH Devamrta Svami Vyasa-puja</option>\n" +
                    "      <option value='A008' >HH Dhanvantari Svami Vyasa-puja</option>\n" +
                    "      <option value='0035' >HH Gopal Krishna Gosvami Vyasa-puja</option>\n" +
                    "      <option value='0037' >HH Gour Govinda Svami Vyasa-puja</option>\n" +
                    "      <option value='00102' >HH Gour Govinda Svami Dissapearance</option>\n" +
                    "      <option value='A012' >HH Hanumatpresaka Svami Vyasa-puja</option>\n" +
                    "      <option value='A001' >HH Hridayananda Dasa Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A022' >HH Indradyumna Svami Vyasa-puja</option>\n" +
                    "      <option value='A004' >HH Jayapataka Svami Vyasa-puja</option>\n" +
                    "      <option value='A033' >HH Kadamba Kanana Svami Vyasa-puja</option>\n" +
                    "      <option value='A059' >HH Kavicandra Svami Vyasa-puja</option>\n" +
                    "      <option value='A018' >HG Kratu Prabhu Vyasa-puja</option>\n" +
                    "      <option value='A002' >HG Krishna Ksetra Dasa Vyasa-puja</option>\n" +
                    "      <option value='A023' >HH Lokanath Svami Vyasa-puja</option>\n" +
                    "      <option value='A057' >HH Mahavisnu Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A020' >HH Niranjana Svami Vyasa-puja</option>\n" +
                    "      <option value='A053' >HH Partha Sarathi Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A041' >HH Radhanath Svami Vyasa-puja</option>\n" +
                    "      <option value='A030' >HH Satsvarupa dasa Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A010' >HH Smita Krishna Svami Vyasa-puja</option>\n" +
                    "      <option value='A006' >HH Sridhara Svami Vyasa-puja</option>\n" +
                    "      <option value='A007' >HH Sridhara Svami Dissappearance</option>\n" +
                    "      <option value='A015' >HH Tamal Krishna Gosvami Vyasa-puja</option>\n" +
                    "      <option value='A009' >HH Tamal Krishna Gosvami Dissappearance</option>\n" +
                    "      <option value='A045' >HH Vedavyasapriya Svami Vyasa-puja</option></select>\n" +
                    "\t</td></tr></table>\n" +
                    "</td><td valign=bottom>\n" +
                    "\t<iframe src='//www.facebook.com/plugins/like.php?href=https%3A%2F%2Fwww.facebook.com%2FVaisnavaCalendar&amp;width=325&amp;layout=standard&amp;action=like&amp;show_faces=true&amp;share=false&amp;height=80&amp;appId=1374613962823729' scrolling='no' frameborder='0' style='border:none; overflow:hidden; height:80px;' allowTransparency='true'></iframe>\n" +
                    "</td></tr>\n" +
                    "</table>\n" +
                    "<TABLE BORDER=1 WIDTH='100%' CELLPADDING=0 ROWSPACING=0>\n" +
                    "  <tr>\n" +
                    "    <td width=1% rowspan=8></td>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Sunday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Monday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Tuesday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Wednesday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Thursday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Friday</TD>\n" +
                    "    <TD width=14% bgcolor=#6F6E6E><center><b>Saturday</TD>\n" +
                    "    <td width=1% rowspan=8></td>\n" +
                    "   </TR>\n" +
                    " \n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dvadasi</td>\n" +
                    "          <td align=center valign=top>1</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top><font size=1>Break fast 04:51 - 09:45 <br>(Daylight saving not considered)</font></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Trayodasi</td>\n" +
                    "          <td align=center valign=top>2</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Caturdasi</td>\n" +
                    "          <td align=center valign=top>3</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=gadadharapandita','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Sri Gadadhara Pandita <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#FF30AA  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=bhaktivinodathakura','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Bhaktivinoda Thakura <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><font size=1>(Fasting till noon)</font></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=E87AFF height=100% valign=top><img src=amavasya.gif border=0></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Pratipat</td>\n" +
                    "          <td align=center valign=top>4</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=gundicamarjana','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Gundica Marjana</a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=gurubbs','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">HH Bhaktibusana Svami <img src=ap.gif alt=Appearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dvitiya</td>\n" +
                    "          <td align=center valign=top>5</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=rathayatra','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Ratha Yatra</a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><font size=1>(Hera Pancami after 4 days)</font></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><font size=1>(Return Ratha after 8 days)</font></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=svarupadamodaragosvami','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Svarupa Damodara Gosvami <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=sivanandasena','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Sivananda Sena <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Tritiya</td>\n" +
                    "          <td align=center valign=top>6</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Caturthi</td>\n" +
                    "          <td align=center valign=top>7</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Pancami</td>\n" +
                    "          <td align=center valign=top>8</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Sasti</td>\n" +
                    "          <td align=center valign=top>9</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=vakresvarapandita','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Vakresvara Pandita <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Saptami</td>\n" +
                    "          <td align=center valign=top>10</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Astami</td>\n" +
                    "          <td align=center valign=top>11</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Astami</td>\n" +
                    "          <td align=center valign=top>12</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Navami</td>\n" +
                    "          <td align=center valign=top>13</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dasami</td>\n" +
                    "          <td align=center valign=top>14</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=FBAC2F height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('https://secure745.websitewelcome.com/~i5kc0n/vaisnavacalendar/cgi-bin/en.cgi?nam=gurulok','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">HH Lokanath Svami <img src=ap.gif alt=Appearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Suddha Ekadasi</td>\n" +
                    "          <td align=center valign=top>15</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top>Sayana Ekadasi</td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dvadasi</td>\n" +
                    "          <td align=center valign=top>16</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#862E98  valign=top><font size=1>Break fast 05:00 - 09:49 <br>(Daylight saving not considered)</font></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top>Cancer</td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Trayodasi</td>\n" +
                    "          <td align=center valign=top>17</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Caturdasi</td>\n" +
                    "          <td align=center valign=top>18</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Purnima</td>\n" +
                    "          <td align=center valign=top>19</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top>Guru (Vyasa) Purnima</td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF  valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=sanatanagosvami','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Sanatana Gosvami <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#559FFB  valign=top>First month of Caturmasya</td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#559FFB  valign=top><font size=1>(Fast from sak, green leafy vegetables)</font></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#559FFB height=100% valign=top><font size=1>(Caturmasya is not observed during Purusottama Adhika Masa)</font></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Pratipat</td>\n" +
                    "          <td align=center valign=top>20</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=E87AFF  valign=top><img src=\"purnima.gif\" border=0></td>\n" +
                    "             </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=6F6E6E height=100% valign=top><b>Sridhara Masa</b></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dvitiya</td>\n" +
                    "          <td align=center valign=top>21</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Tritiya</td>\n" +
                    "          <td align=center valign=top>22</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Caturthi</td>\n" +
                    "          <td align=center valign=top>23</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Pancami</td>\n" +
                    "          <td align=center valign=top>24</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=gopalabhattagosvami','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Gopala Bhatta Gosvami <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Sasti</td>\n" +
                    "          <td align=center valign=top>25</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Astami</td>\n" +
                    "          <td align=center valign=top>26</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=lokanathagosvami','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Srila Lokanatha Gosvami <img src=dis.gif alt=Disppearance border=0></a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Navami</td>\n" +
                    "          <td align=center valign=top>27</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#E87AFF height=100% valign=top><a href=\"javascript:;\" onClick=\"window.open('/cgi-bin/en.cgi?nam=incorporationofiskcon','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">The incorporation of ISKCON in New York</a></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dasami</td>\n" +
                    "          <td align=center valign=top>28</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Suddha Ekadasi</td>\n" +
                    "          <td align=center valign=top>29</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top>Kamika Ekadasi</td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Dvadasi</td>\n" +
                    "          <td align=center valign=top>30</td>\n" +
                    "         </tr>\n" +
                    "             <tr>\n" +
                    "              <td colspan=2 align=center bgcolor=#862E98 height=100% valign=top><font size=1>Break fast 05:11 - 09:53 <br>(Daylight saving not considered)</font></td>\n" +
                    "             </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "    <tr>\n" +
                    "       <td height=80 valign=top>\n" +
                    "        <table border=0 width=100% height=100%>\n" +
                    "         <tr>\n" +
                    "          <td align=center valign=top>Trayodasi</td>\n" +
                    "          <td align=center valign=top>31</td>\n" +
                    "         </tr>\n" +
                    "        </table>\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "       <td height=80 valign=top>&nbsp;\n" +
                    "      </td>\n" +
                    "   </tr>\n" +
                    "</TABLE>\n" +
                    "\n" +
                    "<BR><center>\n" +
                    "<table border=0 CELLSPACING=2>\n" +
                    "\t<tr></td><td>\n" +
                    "       \t<img src=purnima.gif> Full moon |\n" +
                    "\t</td><td>\n" +
                    "       \t<img src=amavasya.gif> New moon |\n" +
                    "\t</td><td>\n" +
                    "       \t<img src=ap.gif height=16> Appearance |\n" +
                    "\t</td><td>\n" +
                    "       \t<img src=dis.gif height=16> Dissapearence | \n" +
                    "\t</td><td width=19 bgcolor=862E98></td><td>\n" +
                    "\t\tEkadasi | \n" +
                    "\t</td><td width=19 bgcolor=559FFB></td><td>\n" +
                    "\t\tCaturmasya\n" +
                    "\t</td></tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "<br>\n" +
                    "<CENTER><b><a href='http://www.iskcon.com.mx/daksina/index.php?lang=en' target=_blank>Help us to preach</a> | <a href=\"javascript:;\" onClick=\"window.open('/add_en.php','_blank','width=500, height=450,scrollbars=1,menubar=0,location=0,toolbar=0,personalbar=0,status=0'); return false\">Add Vaisnava VCalendar to your webpage</a>\n" +
                    "<br><br><SCRIPT SRC='http://www.iskcon.com.mx/cgi-bin/carousel.cgi?tell=js'></SCRIPT></CENTER>\n" +
                    "\n" +
                    "\n" +
                    "</BODY>\n" +
                    "</HTML>\n";
}
