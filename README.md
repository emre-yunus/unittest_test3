De klasse CodeCalculator berekent het resultaat van een code die naar een rekenmachine gestuurd wordt.

De eenvoudigste codes zien er als volgt uit:
> &+(5,4,1) wat resulteert in 5 + 4 + 1 = 10

De code begint steeds met een & : achter de & kunnen de vier basisbewerkingen staan: + , - , * of /. Tussen de haken staan integer getallen, gescheiden door een komma. 

De &+ bij de start kan ook weggelaten worden wat op hetzelfde neerkomt alsof er &+ staat. Volgende twee hebben dan ook een identiek resultaat:
> &+(5,4,1) resulteert in 5 + 4 + 1 = 10
> 
> (5,4,1) resulteert in 5 + 4 + 1 = 10

In het laatste geval kunnen ook de haakjes weggelaten worden. Het volgende heeft dus ook net hetzelfde resultaat (ook dit werkt dus enkel alsof er &+ staat):
> 5,4,1 resulteert in 5 + 4 + 1 = 10

Spaties vooraan en achteraan, en ook spaties tussen de nummers zelf worden vergeven. Bvb.
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   5,&nbsp;&nbsp;&nbsp;4,&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp; resulteert in 5 + 4 + 1 = 10
> 
> (&nbsp;&nbsp;&nbsp;5&nbsp;&nbsp;,4,&nbsp;&nbsp;&nbsp;1) resulteert in 5 + 4 + 1 = 10
>
> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&+(&nbsp;&nbsp;5,4&nbsp;&nbsp;&nbsp;,&nbsp;&nbsp;&nbsp;1&nbsp;)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; resulteert in 5 + 4 + 1 = 10

Bij de aanwezigheid van alle andere karakters resulteert de berekening in 0.

**Je mag ervan uitgaan dat de getallen steeds integers zijn en dat een 0 nooit voorkomt als getal.**
