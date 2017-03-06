%FENÓTIPOS E GENÓTIPOS

% tipoSanguineo(geneP, geneM, fenótipo) ->FATO tipoSanguineo,genótipos e fenótipo
tipoSanguineo('IA', 'IA', 'A').
tipoSanguineo('IA', 'ii', 'A').
tipoSanguineo('ii', 'IA', 'A').
tipoSanguineo('IB', 'IB', 'B').
tipoSanguineo('IB', 'ii', 'B').
tipoSanguineo('ii', 'IB', 'B').
tipoSanguineo('IA', 'IB', 'AB').
tipoSanguineo('IB', 'IA', 'AB').
tipoSanguineo('ii', 'ii', 'O').

%			  ->FATO idSangue, valores usados para gerar
%			  aleatoriedade das variações de genes tipoSanguineo
idSangue(1, 'IA').
idSangue(2, 'IB').
idSangue(3, 'ii').

%calvice(geneP, geneM, sexo, fenótipo)		     ->FATO calvice,genótipos e
%						     fenótipo
calvice('C', 'C', 'masculino', 'sim').
calvice('C', 'C', 'feminino', 'sim').
calvice('C', 'c', 'masculino', 'sim').
calvice('c', 'C', 'masculino', 'sim').
calvice('C', 'c', 'feminino', 'não').
calvice('c', 'C', 'feminino', 'não').
calvice('c', 'c', 'masculino', 'não').
calvice('c', 'c', 'feminino', 'não').
%				    ->FATO idCalvice, valores usados para gerar
%				    aleatoriedade das variações de genes
idCalvice(1, 'c').
idCalvice(2, 'C').

% corOlho(geneP1, geneM1, geneP2, geneM2, fenótipo)
%				    ->FATO corOlho,genótipos e fenotipos
corOlho('BM', _, _, _, 'castanho').
corOlho(_, 'BM', _, _, 'castanho').
corOlho('BA', 'BA', 'GV', _, 'verde').
corOlho('BA', 'BA', _, 'GV', 'verde').
corOlho('BA', 'BA', 'GA', 'GA', 'azul').

idOlhoB(1, 'BM').
idOlhoB(2, 'BA').
%	       ->FATO idOlhoB/G, valores para gerar aleatoriedade das
%	       variações de genes. B para a primeira metade e G para a
%	       segunda.
idOlhoG(1, 'GV').
idOlhoG(2, 'GA').

% corPele(geneP1, geneM1, geneP2, geneM2, fenótipo)
%				        ->FATO corPele,genótipos e fenótipo
corPele('A', 'A', 'B', 'B', 'preto').
corPele('A', 'A', 'B', 'b', 'moreno-escuro').
corPele('A', 'A', 'b', 'B', 'moreno-escuro').
corPele('A', 'A', 'b', 'b', 'moreno').
corPele('A', 'a', 'B', 'B', 'moreno-escuro').
corPele('A', 'a', 'B', 'b', 'moreno').
corPele('A', 'a', 'b', 'B', 'moreno').
corPele('A', 'a', 'b', 'b', 'moreno-claro').
corPele('a', 'A', 'B', 'B', 'moreno-escuro').
corPele('a', 'A', 'B', 'b', 'moreno').
corPele('a', 'A', 'b', 'B', 'moreno').
corPele('a', 'A', 'b', 'b', 'moreno-claro').
corPele('a', 'a', 'B', 'B', 'moreno').
corPele('a', 'a', 'B', 'b', 'moreno-claro').
corPele('a', 'a', 'b', 'B', 'moreno-claro').
corPele('a', 'a', 'b', 'b', 'branco').

idPeleA(1, 'A').
idPeleA(2, 'a').
%	       ->FATO idPeleA/B, valores para gerar aleatoriedade das
%	       variações de genes. A para a primeira metade e B para a segunda.
idPeleB(1, 'B').
idPeleB(2, 'b').

%OPERAÇÕES A PARTE

% regra para retornar na terceira entrada a lista da segunda sem
% qualquer aparição do(s) elemento(s) da primeira entrada
removerTodos(Elem, [Elem], []).
removerTodos(_, [Elem], [Elem]).
removerTodos(Elem, [Elem|Lista1], Lista2):-
	removerTodos(Elem, Lista1, Lista2).
removerTodos(Elem1, [Elem2|Lista1], [Elem2|Lista2]):-
	removerTodos(Elem1, Lista1, Lista2).

% regra onde a segunda lista é feita a partir dos elementos da primeira
% mas sem nenhuma repetição
% listaDiferente([Elem,Elem],[Elem]).
% listaDiferente([Elem1,Elem2], [Elem1,Elem2]).
listaDiferente([],[]).
listaDiferente([Elem|Lista1], [Elem|Lista]):-
	member(Elem, Lista1), removerTodos(Elem, Lista1, Lista2),
	listaDiferente(Lista2,Lista).
listaDiferente([Elem|Lista1], [Elem|Lista]):-
	listaDiferente(Lista1,Lista).
% regra que retorna a porcentagem(s?) Z de frequencia de Elem(segunda
% entrada) em Lista
itemPorcentagem(Lista, [Elem], [[Elem,Z]]):-tamanhoLista(Lista,X), tamanhoListaEspecial(Lista, Elem, Y),
	Z is( Y/X)*100.
itemPorcentagem(Lista1, [Elem|Lista2], [[Elem,Z]|Lista]):-
	tamanhoLista(Lista1,X), tamanhoListaEspecial(Lista1, Elem, Y),
	Z is( Y/X)*100, itemPorcentagem(Lista1,  Lista2, Lista).
%					       Confirmar se X é uma lista
eLista(X):-var(X),!,fail.
eLista([]).
eLista([_|T]):-
	eLista(T).
% regra com em que Gene1 pode ser um ou mais genes(lista), Gene2 2 ou
% mais genes(sempre lista). A última lista da regra é composta de
% combinações de todos os membros de Gene1 com cada membro de Gene2,
% tendo o mesmo tamanho que Gene2.
combinacaoSimples(Gene1, [Gene2], [[Gene1,Gene2]]):- atom(Gene2), atom(Gene1).
combinacaoSimples(Gene1, [Gene2], [[Gene1| Gene2]]):- eLista(Gene2), atom(Gene1).
combinacaoSimples(Gene1, [Gene2], [Lista]):- atom(Gene2), eLista(Gene1),concatenarLista(Gene1, [Gene2], Lista).
combinacaoSimples(Gene1, [Gene2], [Lista]):- eLista(Gene2), eLista(Gene1), concatenarLista(Gene1, Gene2, Lista).
combinacaoSimples(Gene1,[Gene2|ListaGenes],[[Gene1,Gene2]|ListaPares]):-
	combinacaoSimples(Gene1, ListaGenes, ListaPares), atom(Gene2), atom(Gene1).
combinacaoSimples(Gene1,[Gene2|ListaGenes],[[Gene1|Gene2]|ListaPares]):-
	combinacaoSimples(Gene1, ListaGenes, ListaPares), eLista(Gene2), atom(Gene1).
combinacaoSimples(Gene1,[Gene2|ListaGenes],[Lista|ListaPares]):-
	combinacaoSimples(Gene1, ListaGenes, ListaPares), atom(Gene2), eLista(Gene1),
	concatenarLista(Gene1, [Gene2], Lista).
combinacaoSimples(Gene1,[Gene2|ListaGenes],[Lista|ListaPares]):-
	combinacaoSimples(Gene1, ListaGenes, ListaPares), eLista(Gene2),eLista(Gene1),
	concatenarLista(Gene1, Gene2, Lista).
%	  regra onde a terceira Lista é a concatenação da primeira com a
%	  segunda
concatenarLista([], Lista, Lista).           %caso base final?
concatenarLista([Cabeca|Lista1], Lista2, [Cabeca|Lista3]):-
	concatenarLista(Lista1, Lista2, Lista3).

%	regra para combinar cada gene da primeira lista com cada gene da
%	segunda lista e retornar essas combinações em ListaPares
pareamentoGenes([Gene1], Lista, ListaPares ):-combinacaoSimples(Gene1, Lista, ListaPares).%caso primeira lista seja uma lista de um gene(ou lista de listas)/caso final?
pareamentoGenes([Inicio|Gene1], Gene2, ListaG):-
	combinacaoSimples(Inicio, Gene2, Simples),
	pareamentoGenes(Gene1, Gene2, Lista),
	concatenarLista(Simples, Lista, ListaG).
%    regra para retornar tamanho de lista
tamanhoLista([], 0).
tamanhoLista([_|Lista], Soma):-
	tamanhoLista(Lista, Soma1), Soma is Soma1 + 1.

%    regra que conta quantos Elem(segunda entrada) existem na lista que
%    é a primeira entrada [?] e retorna a quantidade na terceira entrada
tamanhoListaEspecial([Elem], Elem, 1 ).   %valor inicio do contador
tamanhoListaEspecial([_], _, 0)/*:- Elem1 =\= Elem2*/.
tamanhoListaEspecial([Head|Tail], Head, Soma):-         %caso proximo elemento seja igual
	tamanhoListaEspecial(Tail, Head, Soma1), Soma is Soma1 + 1.
tamanhoListaEspecial([_|Tail], Head2, Soma):-           %caso proximo elemento seja diferente
	tamanhoListaEspecial(Tail, Head2, Soma1), /*Head1 =\= Head2,*/ Soma is Soma1 + 0.

%'aleatorioX' usado para gerar número aleatório de 0 à X
aleatorio2(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 2)+1.
aleatorio3(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 3)+1.
aleatorio4(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 4)+1.

%TIPO SANGUINEO
%			    regra identifica combinações de 2 genes e seu fenótipo
listaSangue([[X,Y]], [Fenotipo]):- tipoSanguineo(X, Y, Fenotipo).
%			    regra para lista com 2 ou mais combinações
%			    de pares de genes e uma outra lista com os
%			    respectivos fenótipos dos pares da primeira lista
listaSangue([[X,Y]|Lista1], [Fenotipo|Lista2]):-
	listaSangue(Lista1, Lista2), tipoSanguineo(X, Y, Fenotipo).

%		       regra combina os gene(s) de GeneP e GeneM em
%		       pares e retorna em Tipos uma lista dos fenótipos
%		       identificados por esses pares
retornaFenotipoSanguineo(GeneP, GeneM, Tipos):-
	pareamentoGenes(GeneP, GeneM, Lista2), listaSangue(Lista2, Tipos).

%		       regra que baseado nos gene(s) GeneP e GeneM
%		       e no tipo sanguineo em Fenotipo retorna sua
%		       chance em Percentual
probabilidadeSanguineo(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoSanguineo(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.
%		       regra para gerar uma combinação aleatoria para
%		       cada um dos 2 alelos de um gene de uma pessoa
gerarGeneSangue([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]]):-
	aleatorio3(Num1), idSangue(Num1, X),
	aleatorio3(Num2), idSangue(Num2, Y).
%		       mesmo que probabilidadeSanguineo mas utilizando
%		       pessoas cadastradas
probabilidadeSangueNome(Pai, Mae, Fenotipo, Percentual):-
	consultaPessoa(Pai, [Gene1|_]), consultaPessoa(Mae, [Gene2|_]),
	probabilidadeSanguineo(Gene1, Gene2, Fenotipo, Percentual).
%		      regra que retorna Lista (sem repetições) de cada
%		      fenótipo(tipo sanguineo)e suas porcentagens de
%		      acontecimento baseado em Pai e Mae
probabilidadeSangueTodos(Pai, Mae, Lista):-
	consultaPessoa(Pai, [Gene1|_]), consultaPessoa(Mae, [Gene2|_]),
	retornaFenotipoSanguineo(Gene1, Gene2, Tipos), itemPorcentagem(Tipos, Tipos, Lista1),
	listaDiferente(Lista1,Lista).

%PRESENÇA DE CALVICIE

%		      regra para identificar o fenotipo baseado numa
%		      lista com 2 genes e Z=sexo
listaCalvice([[X,Y,Z]], [Fenotipo]):- calvice(X,Y,Z, Fenotipo).
%		      regra para lista com listas de 2 genes e sexo que
%		      retorna lista de fenotipos para cada lista de
%		      genes e sexo.
listaCalvice([[X,Y,Z]|Lista1],[Fenotipo|Lista2]):-
	listaCalvice(Lista1, Lista2), calvice(X,Y,Z, Fenotipo).
%		      regra para combinar cada gene(s) de GeneP e GeneM,
%		      e cada par combinado com um sexo, para então
%		      retornar uma Lista de fenótipos correspondetes
retornaFenotipoCalvice(GeneP, GeneM, Lista):-
	pareamentoGenes(GeneP, GeneM, Lista1),
	pareamentoGenes(Lista1, ['masculino','feminino'], Lista2),
	listaCalvice(Lista2, Lista).
%		      regra que retorna em Percentual a chance do
%		      Fenotipo dado aparecer baseado nos genes de GeneP
%		      e GeneM
probabilidadeCalvice(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoCalvice(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.
%		      regra que gera 2 combinações aleatórias de alelos
%		      sendo 1 alelo dessas duas combinações da
%		      combinação original na primeira entrada
gerarGeneCalvice([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]]):-
	aleatorio2(Num1), idCalvice(Num1, X),
	aleatorio2(Num2), idCalvice(Num2, Y).
%		      regra identica a probabilidadeCalvice, mas
%		      funciona baseado em pessoas cadastradas
probabilidadeCalvicieNome(Pai, Mae, Fenotipo, Percentual):-
	consultaPessoa(Pai, [_,[G1,G2,_]|_]), consultaPessoa(Mae, [_,[G3,G4,_]|_]),
	probabilidadeCalvice([G1,G2],[G3,G4], Fenotipo, Percentual).
%		      regra que retorna Lista (sem repetições) de cada
%		      fenótipo(calvo ou não) e suas porcentagens de
%		      acontecimento baseado em Pai e Mae
probabilidadeCalvicieTodos(Pai, Mae, Lista):-
	consultaPessoa(Pai, [_,[G1,G2,_]|_]), consultaPessoa(Mae, [_,[G3,G4,_]|_]),
	retornaFenotipoCalvice([G1,G2], [G3,G4], Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2, Lista).

%TIPO OLHO

%
listaOlho([[W,X,Y,Z]], [Fenotipo]):- corOlho(W,X,Y,Z, Fenotipo).
listaOlho([[W,X,Y,Z]|Lista1], [Fenotipo|Lista2]):-
	listaOlho(Lista1, Lista2), corOlho(W,X,Y,Z, Fenotipo).

retornaFenotipoOlho(GeneP1, GeneP2, GeneM1, GeneM2, Lista):-
	pareamentoGenes(GeneP1, GeneM1, Lista1),
	pareamentoGenes(GeneP2, GeneM2, Lista2),
	pareamentoGenes(Lista1, Lista2, Lista3),
	listaOlho(Lista3, Lista).

probabilidadeOlho(GeneP1, GeneP2, GeneM1, GeneM2, Fenotipo, Percentual):-
	retornaFenotipoOlho(GeneP1, GeneP2, GeneM1, GeneM2, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

gerarGeneOlho([Alelo1,Alelo2], [Alelo3,Alelo4],[[Alelo1, W],[Alelo3, X],[Alelo2, Y],[Alelo4, Z]]):-
	aleatorio2(Num1), idOlhoB(Num1, W),
	aleatorio2(Num2), idOlhoG(Num2, X),
	aleatorio2(Num3), idOlhoB(Num3, Y),
	aleatorio2(Num4), idOlhoG(Num4, Z).

probabilidadeOlhoNome(Pai, Mae, Fenotipo, Percentual):-
	consultaPessoa(Pai, [_,_,[O1,O2,O3,O4],_]), consultaPessoa(Mae, [_,_,[O5,O6,O7,O8],_]),
	probabilidadeOlho([O1,O2], [O3,O4], [O5,O6], [O7,O8], Fenotipo, Percentual).

probabilidadeOlhoTodos(Pai, Mae, Lista):-
	consultaPessoa(Pai, [_,_,[O1,O2,O3,O4],_]), consultaPessoa(Mae, [_,_,[O5,O6,O7,O8],_]),
	retornaFenotipoOlho([O1,O2],[O3,O4],[O5,O6],[O7,O8],Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2,Lista).

%TIPO PELE

listaPele([[W,X,Y,Z]], [Fenotipo]):- corPele(W,X,Y,Z, Fenotipo).
listaPele([[W,X,Y,Z]|Lista1], [Fenotipo|Lista2]):-
	listaPele(Lista1, Lista2), corPele(W,X,Y,Z, Fenotipo).

retornaFenotipoPele(GeneP1, GeneP2, GeneM1, GeneM2, Lista):-
	pareamentoGenes(GeneP1, GeneM1, Lista1),
	pareamentoGenes(GeneP2, GeneM2, Lista2),
	pareamentoGenes(Lista1, Lista2, Lista3),
	listaPele(Lista3, Lista).

probabilidadePele(GeneP1, GeneP2, GeneM1, GeneM2, Fenotipo, Percentual):-
	retornaFenotipoPele(GeneP1, GeneP2, GeneM1, GeneM2, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

gerarGenePele([Alelo1,Alelo2], [Alelo3,Alelo4],[[Alelo1, W],[Alelo3, X],[Alelo2, Y],[Alelo4, Z]]):-
	aleatorio2(Num1), idPeleA(Num1, W),
	aleatorio2(Num2), idPeleB(Num2, X),
	aleatorio2(Num3), idPeleA(Num3, Y),
	aleatorio2(Num4), idPeleB(Num4, Z).

probabilidadePeleNome(Pai, Mae, Fenotipo, Percentual):-
	consultaPessoa(Pai, [_,_,_,[P1,P2,P3,P4]]), consultaPessoa(Mae, [_,_,_,[P5,P6,P7,P8]]),
	probabilidadePele([P1,P2],[P3,P4],[P5,P6],[P7,P8], Fenotipo, Percentual).

probabilidadePeleTodos(Pai, Mae, Lista):-
	consultaPessoa(Pai, [_,_,_,[P1,P2,P3,P4]]), consultaPessoa(Mae, [_,_,_,[P5,P6,P7,P8]]),
	retornaFenotipoPele([P1,P2],[P3,P4],[P5,P6],[P7,P8], Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2, Lista).

%ARVORE GENEALOGICA

%		      regra para gerar combinações de genes(pai e mãe)
%		      baseado nas combinações das 4 primeiras listas
pai_mae([[S1,S2],[C1,C2],[B1,B2,G1,G2],[A1,A2,P1,P2]],[[PS, PC, OlhoP, PeleP],[MS,MC,OlhoM,PeleM]]):-
	gerarGeneSangue([S1,S2], [PS, MS]),
	gerarGeneCalvice([C1,C2], [PC, MC]),
	gerarGeneOlho([B1,B2],[G1,G2],[O1,O2,O3,O4]),
	concatenarLista(O1,O2, OlhoP),
	concatenarLista(O3,O4, OlhoM),
	gerarGenePele([A1,A2],[P1,P2],[Pe1,Pe2,Pe3,Pe4]),
	concatenarLista(Pe1,Pe2, PeleP),
	concatenarLista(Pe3,Pe4, PeleM).

%		      regra que baseado numa lista de 1 ou mais
%		      Individuo(s), gera uma lista Pais com os possíveis
%		      genes geradores gerados por pai_mae
gerarPais([Individuo], Pais):- pai_mae(Individuo, Pais).
gerarPais([Individuo|Individuos], Pais):-
	gerarPais(Individuos, PM2),
	pai_mae(Individuo, PM1),
	concatenarLista(PM1,PM2, Pais).
%		      regra onde na terceira entrada Arvore retorna uma
%		      lista com combinações de genes geradas a partir de
%		      gerarPais baseado na lista de um ou mais Filhos. A
%		      quantidade gerada depende do valor  Nivel
preArvore(Nivel, Filhos, Arvore):- tamanhoLista(Filhos, X),  Y is 2^(Nivel - 1),
	Y = X, gerarPais(Filhos, Arvore).
preArvore(Nivel, Pessoa, Arvore):-
	gerarPais(Pessoa, Pais),
	preArvore(Nivel, Pais, SubArvore),
	concatenarLista(Pais, SubArvore, Arvore).
%		      regra para concatenar listas com listas de genes
%		      de individuos em uma unica lista com listas onde
%		      cada uma representa todos os genes de um individuo
formarListaUnica([[[S1,S2],[C1,C2],[O1,O2,O3,O4],[P1,P2,P3,P4]]],[S1,S2,C1,C2,O1,O2,O3,O4,P1,P2,P3,P4]).
formarListaUnica([[[S1,S2],[C1,C2],[O1,O2,O3,O4],[P1,P2,P3,P4]]|Individuos], ListaUnica):-
	formarListaUnica(Individuos, Lista),
	concatenarLista([S1,S2,C1,C2,O1,O2,O3,O4,P1,P2,P3,P4], Lista, ListaUnica).
%		      regra que utilizando de preArvore gera uma lista
%		      Arvore baseada numa Pessoa cadastrada e seus
%		      genes.
arvoreGenealogica(Pessoa, Arvore, Nivel):-
	consultaPessoa(Pessoa,[[S1,S2],[C1,C2,_],[O1,O2,O3,O4],[P1,P2,P3,P4]]),
	preArvore(Nivel, [[[S1,S2],[C1,C2],[O1,O2,O3,O4],[P1,P2,P3,P4]]], SubArvoreR),
	reverse(SubArvoreR, SubArvore),concatenarLista([S1,S2,C1,C2,O1,O2,O3,O4,P1,P2,P3,P4], [Pessoa], Ultimo),
	formarListaUnica(SubArvore, ListaUnica), concatenarLista(ListaUnica, Ultimo, Arvore).

%Descendentes até um nivel dado

%		      regra que retorna uma combinação de alelos na
%		      terceira entrada baseado nas outras duas primeiras
%		      combinações. O valor Z determina quais serão esses
%		      alelos.
geneFilho([Alelo1,_], [Alelo2, _], [Alelo1,Alelo2], Z):- Z = 1.
geneFilho([Alelo1,_], [_, Alelo2], [Alelo1,Alelo2], Z):- Z = 2.
geneFilho([_,Alelo1], [Alelo2, _], [Alelo1,Alelo2], Z):- Z = 3.
geneFilho([_,Alelo1], [_, Alelo2], [Alelo1,Alelo2], Z):- Z = 4.
%		      regra para gerar genes filho a partir de
%		      diferentes combinações de genes (pai e mãe)
%		      selecionando quais genes serão herdades
%		      aleatoriamente. Essas combinações geradas são
%		      especificas para calvicie dominante (homem)
gerarFilho([[PS1, PS2],[PC1,PC2, 'masculino'],[PO1,PO2,PO3,PO4],[PL1,PL2,PL3,PL4]],
	   [[MS1, MS2],[MC1,MC2, 'feminino'],[MO1,MO2,MO3,MO4],[ML1,ML2,ML3,ML4]],
	   [[Sangue, [CA, CB, 'masculino'], [O1,O2,O3,O4], [P1,P2,P3,P4]],
	   [[[PS1, PS2],[PC1,PC2, 'masculino'],[PO1,PO2,PO3,PO4],[PL1,PL2,PL3,PL4]],
	   [[MS1, MS2],[MC1,MC2, 'feminino'],[MO1,MO2,MO3,MO4],[ML1,ML2,ML3,ML4]]]] ):-
	aleatorio4(A), geneFilho([PS1, PS2],[MS1, MS2], Sangue, A),
	aleatorio4(B), geneFilho([PC1,PC2],[MC1,MC2], [CA,CB], B),
	aleatorio4(C), geneFilho([PO1,PO2],[MO1,MO2], [O1,O2], C),
	aleatorio4(D), geneFilho([PO3,PO4],[MO3,MO4], [O3,O4], D),
	aleatorio4(E), geneFilho([PL1,PL2],[ML1,ML2], [P1,P2], E),
	aleatorio4(F), geneFilho([PL3,PL4],[ML3,ML4], [P3,P4], F).
%		      regra identica a de cima mas as combinações são
%		      baseadas na calvicie recessiva (mulher)
gerarFilha([[PS1, PS2],[PC1,PC2, 'masculino'],[PO1,PO2,PO3,PO4],[PL1,PL2,PL3,PL4]],
	   [[MS1, MS2],[MC1,MC2, 'feminino'],[MO1,MO2,MO3,MO4],[ML1,ML2,ML3,ML4]],
	   [[Sangue, [CA, CB, 'feminino'], [O1,O2,O3,O4], [P1,P2,P3,P4]],
	   [[[PS1, PS2],[PC1,PC2, 'masculino'],[PO1,PO2,PO3,PO4],[PL1,PL2,PL3,PL4]],
	   [[MS1, MS2],[MC1,MC2, 'feminino'],[MO1,MO2,MO3,MO4],[ML1,ML2,ML3,ML4]]]] ):-
	aleatorio4(A), geneFilho([PS1, PS2],[MS1, MS2], Sangue, A),
	aleatorio4(B), geneFilho([PC1,PC2],[MC1,MC2], [CA,CB], B),
	aleatorio4(C), geneFilho([PO1,PO2],[MO1,MO2], [O1,O2], C),
	aleatorio4(D), geneFilho([PO3,PO4],[MO3,MO4], [O3,O4], D),
	aleatorio4(E), geneFilho([PL1,PL2],[ML1,ML2], [P1,P2], E),
	aleatorio4(F), geneFilho([PL3,PL4],[ML3,ML4], [P3,P4], F).
%		      regra para gerar lista de Filho(s) baseado em Pai,
%		      Mae e Quantidade
listaFilhos(Pai, Mae, Quantidade, [Filho]):- Quantidade = 1, gerarFilho(Pai, Mae, Filho).
listaFilhos(Pai, Mae, Quantidade, [Filho|Filhos]):-
	Resto is Quantidade - 1, listaFilhos(Pai, Mae, Resto, Filhos),
	gerarFilho(Pai, Mae, Filho).
%		      regra para gerar lista de Filha(s) baseado em Pai,
%		      Mae e Quantidade
listaFilhas(Pai, Mae, Quantidade, [Filha]):- Quantidade = 1, gerarFilha(Pai, Mae, Filha).
listaFilhas(Pai, Mae, Quantidade, [Filha|Filhas]):-
	Resto is Quantidade - 1, listaFilhas(Pai, Mae, Resto, Filhas),
	gerarFilha(Pai, Mae, Filha).
%		      regra que retorna na segunda entrada a mesma lista
%		      que na primeira mas sem o seu ultimo elemento
tiraUlt([_],[]).
tiraUlt([Cabeca|Cauda], [Cabeca|Lista]):-
	tiraUlt(Cauda, Lista).
%		      regra que retorna na terceira entrada uma Lista
%		      cópia da primeira mas sem o elemento dado no
%		      índice informado na segunda entrada.
removerLista(Lista1, 1, Lista2):- tiraUlt(Lista1, Lista2).
removerLista([_|Lista], Num1, Lista):- tamanhoLista([_|Lista], Num2), Num1 = Num2.
removerLista([Head1|Cauda1], Indice, [Head1|Cauda2]):-
	removerLista(Cauda1, Indice, Cauda2).
%		      regra que retorna na segunda entrada o ultimo
%		      elemento da lista.
retornaUlt([Ultimo], Ultimo).
retornaUlt([_|Cauda], Ultimo):-
	retornaUlt(Cauda, Ultimo).
%		      regra que retorna na terceira entrada um Elemento
%		      no dado índice da Lista informado na primeira
%		      entrada
pegarLista(Lista, 1, Elemento):- retornaUlt(Lista, Elemento).
pegarLista([Cabeca|Cauda], Indice, Cabeca):-
	tamanhoLista([Cabeca|Cauda], X), Indice = X.
pegarLista([_|Cauda], Indice, Elemento):-
	pegarLista(Cauda, Indice, Elemento).
%		      regra recebe duas listas de individuos (Homens,
%		      Mulheres) e forma Casais(lista) com um Homem e uma
%		      Mulher aleatórios dessas listas ao mesmo tempo que
%		      os vão removendo delas. Para se sobrar
%		      homem/mulher.
formarCasais([], _, []).
formarCasais(_, [], []).
formarCasais(Homens, Mulheres, [[Homem, Mulher]|Casais]):-
	tamanhoLista(Homens, V), random(W), X is W * 100000,
	round(X, Y), Z is (Y mod V) + 1,
	tamanhoLista(Mulheres, A), random(B), C is B * 100000,
	round(C, D), E is (D mod A) + 1,
	pegarLista(Homens, Z, Homem),
	removerLista(Homens, Z, Homens1),
	pegarLista(Mulheres, E, Mulher),
	removerLista(Mulheres, E, Mulheres1),
	formarCasais(Homens1, Mulheres1, Casais),!.
%		      regra que gera uma lista com duas listas, uma para
%		      Filhos e outra para Filhas, baseados nos
%		      individuos Homem e Mulher. A quantidade de filh@s
%		      é aleatória para cada Homem com cada Mulher.
filhosCasais([[[Homem,_],[Mulher,_]]],[Filhos,Filhas]):-
	aleatorio2(X), listaFilhos(Homem, Mulher, X, Filhos),
	listaFilhas(Homem, Mulher, X, Filhas).
filhosCasais([[[Homem,_], [Mulher,_]]|Casais], [Filhos, Filhas]):-
	aleatorio2(X), listaFilhos(Homem, Mulher, X, Filhos1),
        listaFilhas(Homem, Mulher, X, Filhas1),
	filhosCasais(Casais, [Filhos2, Filhas2]),
	concatenarLista(Filhos1, Filhos2, Filhos),
	concatenarLista(Filhas1, Filhas2, Filhas).
%		      regra recebe lista(com listas) de Casais na
%		      primeira entrada e retorna lista com lista de
%		      filhos/netos/bisnetos/etc Descendentes gerados
%		      aleatoriamente de filhosCasais e organizados em
%		      casais com formarCasais (incesto?). Quantidade
%		      baseada na terceira entrada Nivel.
preDescendentes(Casais, [Descendentes], 1):- filhosCasais(Casais, Descendentes).
preDescendentes(Casal, [Casais|Descendentes], Nivel):-
	filhosCasais(Casal,[Filhos,Filhas]),
	formarCasais(Filhos, Filhas, Casais),
	Resto is Nivel - 1,
	preDescendentes(Casais, Descendentes, Resto).
%		      regra similar a anterior mas inserindo Homem e
%		      Mulher em entradas separadas.
descendentes(Homem, Mulher, Descendentes, Nivel):-
	preDescendentes([[[Homem,_], [Mulher,_]]], Descendentes, Nivel).


%INSERÇÃO E CONSULTA
% verificar se string ou lista é vazia
vazio('').
vazio([]).
%		      regra para cadastrar uma pessoa no arquivo
%		      pessoas.txt baseado nos dados passados pelo
%		      programa em Java
inserirPessoa(pessoa(Nome,_)):-vazio(Nome),!,fail.
inserirPessoa(pessoa(_,[Sangue|_])):-vazio(Sangue),!,fail.
inserirPessoa(pessoa(_,[_,Calvicie|_])):-vazio(Calvicie),!,fail.
inserirPessoa(pessoa(_,[_,_,Olho,_])):-vazio(Olho),!,fail.
inserirPessoa(pessoa(_,[_,_,_,Pele])):-vazio(Pele),!,fail.
inserirPessoa(pessoa(Nome, _)):- absolute_file_name('pessoas.txt',Destino),
consult(Destino), pessoa(Nome, _) , write('Nome já cadastrado!'), !, fail.
inserirPessoa(Pessoa):-absolute_file_name('pessoas.txt',Destino),
append(Destino),writeq(Pessoa),write('.'), write('\n'), told.
consultaPessoa(Nome, Genes):-absolute_file_name('pessoas.txt',Destino),
consult(Destino), pessoa(Nome, Genes).

%COMPATIBILIDADE
%		      regra para verificar se uma combinação de
%		      alelos(terceira entrada) pode ter sido
%		      gerada das outras duas primeiras combinações
genePossivel([Alelo1,_],[Alelo2,_],[Alelo1,Alelo2]).
genePossivel([Alelo1,_],[_,Alelo2],[Alelo1,Alelo2]).
genePossivel([_,Alelo1],[Alelo2,_],[Alelo1,Alelo2]).
genePossivel([_,Alelo1],[_,Alelo2],[Alelo1,Alelo2]).
genePossivel([Alelo1,_],[Alelo2,_],[Alelo2,Alelo1]).
genePossivel([Alelo1,_],[_,Alelo2],[Alelo2,Alelo1]).
genePossivel([_,Alelo1],[Alelo2,_],[Alelo2,Alelo1]).
genePossivel([_,Alelo1],[_,Alelo2],[Alelo2,Alelo1]).
%		      regra que baseado em cada combinação de genes de
%		      Pai, Mae e Filho verifica se os genes de Pai e Mae
%		      poderiam ter gerados os genes de Filho
compatibilidade(Pai, Mae, Filho):-
consultaPessoa(Pai,[SangueP, [C1P,C2P,_],[O1P,O2P,O3P,O4P],[P1P,P2P,P3P,P4P]]),
consultaPessoa(Mae,[SangueM, [C1M,C2M,_],[O1M,O2M,O3M,O4M],[P1M,P2M,P3M,P4M]]),
consultaPessoa(Filho,[SangueF, [C1F,C2F,_],[O1F,O2F,O3F,O4F],[P1F,P2F,P3F,P4F]]),
genePossivel(SangueP, SangueM, SangueF),genePossivel([C1P,C2P], [C1M,C2M], [C1F,C2F]),
genePossivel([O1P,O2P],[O1M,O2M],[O1F,O2F]),genePossivel([O3P,O4P],[O3M,O4M],[O3F,O4F]),
genePossivel([P1P,P2P],[P1M,P2M],[P1F,P2F]),genePossivel([P3P,P4P],[P3M,P4M],[P3F,P4F]).

%testes
teste([1,[2,[3]]]).


















































