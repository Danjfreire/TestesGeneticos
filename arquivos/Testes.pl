
happy(yolanda).
listens2Music(mia).
listens2Music(yolanda):-happy(yolanda).
playsAirGuitar(mia):-listens2Music(mia).
playsAirGuitar(yolanda):-listens2Music(yolanda).
loves(vincent,mia).
loves(marsellus,mia).
loves(pumpkin,honey_bunny).
loves(honey_bunny,pumpkin). %top kekule lololololo
lista([1,[2,3]]).
lista([pipoca, chocolate, [carrot, vegetal]]).
lista([[a,b,c],[1,2,3],[lul]]).

jealous(X,Y):-  loves(X,Z),  loves(Y,Z).
