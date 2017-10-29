# Design report for TicTacToe

This is an assignment in the course 

## The project
 fólst í að útfæra leikinn TicTacToe, eða myllu. Við notuðum til þess agile aðferðir og test driven development. Við notuðumst við git til að halda utan um version control og feature branch workflow.
Leikurinn
TicTacToe er tveggja manna leikur þar sem öðrum leikmanni er úthlutað merkið X og hinum O. Leikurinn er spilaður á borði sem samanstendur af níu reitum settum upp sem 3x3. Tilgangur leiksins er að ná þremur af sínum merkjum í röð, hvort sem það er lárétt, lóðrétt eða á ská en það er líka möguleiki á jafntefli þar sem hvorugur leikmaður nær þremur í röð.
Hönnunin
Við kusum að útfæra leikinn í einfaldri mynd þar sem maður spilar á móti manni og leikur er gerður með því að smella á reit á borðinu þegar viðkomandi á leik. Við höfðum hugsað okkur að útfæra möguleikann á að spila á móti tölvu sienna meir ef tími gæfist til en það tókst ekki fyrir áætluð verklok?
Hér að neðan má sjá myndir af útfærslu okkar af leiknum (myndir hér).
Forritunin
Eins og kom fram hér ofar var notast við feature branch workflow, en í því felst að nýtt branch er búið til fyrir hvern hlut sem er útfærður. Þannig geta margir forritarar auðveldlega unnið að sama verkefninu í einu án mikilla vandræða. 
Klasar
Við upphaf verkefnis höfðum við útfært klasarit með þremur klösum. Það voru player, board og game (man ekki alveg, þarf að laga þegar ég kemst á netið). Við byrjuðum á að útfæra þá klasa sem voru fyrirfram skilgreindir eftir hönnun okkar og bættum svo við þeim föllum sem þurfti þegar leið á verkefnið. Hér fyrir neðan má svo sjá lokaútkomu á klasariti fyrir forritið okkar.
(myndir hér)
