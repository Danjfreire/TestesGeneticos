%Fenótipos e genótipos

%tipoSanguineo(geneP, geneM, fenótipo)
tipoSanguineo('IA', 'IA', 'A').
tipoSanguineo('IA', 'i', 'A').
tipoSanguineo('i', 'IA', 'A').
tipoSanguineo('IB', 'IB', 'B').
tipoSanguineo('IB', 'i', 'B').
tipoSanguineo('i', 'IB', 'B').
tipoSanguineo('IA', 'IB', 'AB').
tipoSanguineo('IB', 'IA', 'AB').
tipoSanguineo('i', 'i', 'O').

idSangue(1, 'IA').
idSangue(2, 'IB').
idSangue(3, 'i').

%calvice(geneP, geneM, sexo, fenótipo)
calvice('C', 'C', _, 'sim').
calvice('C', 'c', 'masculino', 'sim').
calvice('c', 'C', 'masculino', 'sim').
calvice('C', 'c', 'feminino', 'nao').
calvice('c', 'C', 'feminino', 'nao').
calvice('c', 'c', _, 'nao').

idCalvice(1, 'c').
idCalvice(2, 'C').

%corOlho(geneP1, geneM1, geneP2, geneM2, fenótipo)
corOlho('BM', _, _, _, 'castanho').
corOlho(_, 'BM', _, _, 'castanho').
corOlho('BA', 'BA', 'GV', _, 'verde').
corOlho('BA', 'BA', _, 'GV', 'verde').
corOlho('BA', 'BA', 'GA', 'GA', 'azul').

idOlhoB(1, 'BM').
idOlhoB(2, 'BA').

idOlhoG(1, 'GV').
idOlhoG(2, 'GA').

%corPele(geneP1, geneM1, geneP2, geneM2, fenótipo)
corPele('A', 'A', 'B', 'B', 'preta').
corPele('A', 'A', 'B', 'b', 'morena_escura').
corPele('A', 'A', 'b', 'B', 'morena_escura').
corPele('A', 'A', 'b', 'b', 'morena').
corPele('A', 'a', 'B', 'B', 'morena_escura').
corPele('A', 'a', 'B', 'b', 'morena').
corPele('A', 'a', 'b', 'B', 'morena').
corPele('A', 'a', 'b', 'b', 'morena_clara').
corPele('a', 'A', 'B', 'B', 'morena_escura').
corPele('a', 'A', 'B', 'b', 'morena').
corPele('a', 'A', 'b', 'B', 'morena').
corPele('a', 'A', 'b', 'b', 'morena_clara').
corPele('a', 'a', 'B', 'B', 'morena').
corPele('a', 'a', 'B', 'b', 'morena_clara').
corPele('a', 'a', 'b', 'B', 'morena_clara').
corPele('a', 'a', 'b', 'b', 'branca').

idPeleA(1, 'A').
idPeleA(2, 'a').

idPeleB(1, 'B').
idPeleB(2, 'b').

%Operacoes

eLista(X):-var(X),!,fail.
eLista([]).
eLista([_|T]):-
	eLista(T).

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

concatenarLista([], Lista, Lista).
concatenarLista([Cabeca|Lista1], Lista2, [Cabeca|Lista3]):-
	concatenarLista(Lista1, Lista2, Lista3).

pareamentoGenes([Gene1], Lista, ListaPares ):-combinacaoSimples(Gene1, Lista, ListaPares).
pareamentoGenes([Inicio|Gene1], Gene2, ListaG):-
	combinacaoSimples(Inicio, Gene2, Simples),
	pareamentoGenes(Gene1, Gene2, Lista),
	concatenarLista(Simples, Lista, ListaG).

tamanhoLista([], 0).
tamanhoLista([_|Lista], Soma):-
	tamanhoLista(Lista, Soma1), Soma is Soma1 + 1.

tamanhoListaEspecial([Elem], Elem, 1 ).
tamanhoListaEspecial([Elem1], Elem2, 0)/*:- Elem1 =\= Elem2*/.
tamanhoListaEspecial([Head|Tail], Head, Soma):-
	tamanhoListaEspecial(Tail, Head, Soma1), Soma is Soma1 + 1.
tamanhoListaEspecial([Head1|Tail], Head2, Soma):-
	tamanhoListaEspecial(Tail, Head2, Soma1), /*Head1 =\= Head2,*/ Soma is Soma1 + 0.

aleatorio2(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 2)+1.
aleatorio3(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 3)+1.

%Tipo sangue

listaSangue([[X,Y]], [Fenotipo]):- tipoSanguineo(X, Y, Fenotipo).
listaSangue([[X,Y]|Lista1], [Fenotipo|Lista2]):-
	listaSangue(Lista1, Lista2), tipoSanguineo(X, Y, Fenotipo).

retornaFenotipoSanguineo(GeneP, GeneM, Lista):-
	pareamentoGenes(GeneP, GeneM, Lista2), listaSangue(Lista2, Lista).

probabilidadeSanguineo(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoSanguineo(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

gerarGeneSangue([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]]):-
	aleatorio3(Num1), idSangue(Num1, X),
	aleatorio3(Num2), idSangue(Num2, Y).

%Tipo calvice

listaCalvice([[X,Y,Z]], [Fenotipo]):- calvice(X,Y,Z, Fenotipo).
listaCalvice([[X,Y,Z]|Lista1],[Fenotipo|Lista2]):-
	listaCalvice(Lista1, Lista2), calvice(X,Y,Z, Fenotipo).

retornaFenotipoCalvice(GeneP, GeneM, Lista):-
	pareamentoGenes(GeneP, GeneM, Lista1),
	pareamentoGenes(Lista1, ['masculino','feminino'], Lista2),
	listaCalvice(Lista2, Lista).

probabilidadeCalvice(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoCalvice(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

gerarGeneCalvice([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]]):-
	aleatorio2(Num1), idCalvice(Num1, X),
	aleatorio2(Num2), idCalvice(Num2, Y).

%Tipo olho

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

%Tipo pele

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

%Arvore genealogica

pai_mae([[S1,S2],[C1,C2],[B1,B2,G1,G2],[A1,A2,P1,P2]],[[PS, PC, OlhoP, PeleP],[MS,MC,OlhoM,PeleM]]):-
	gerarGeneSangue([S1,S2], [PS, MS]),
	gerarGeneCalvice([C1,C2], [PC, MC]),
	gerarGeneOlho([B1,B2],[G1,G2],[O1,O2,O3,O4]),
	concatenarLista(O1,O2, OlhoP),
	concatenarLista(O3,O4, OlhoM),
	gerarGenePele([A1,A2],[P1,P2],[Pe1,Pe2,Pe3,Pe4]),
	concatenarLista(Pe1,Pe2, PeleP),
	concatenarLista(Pe3,Pe4, PeleM).

arvore(Nivel, Individuo, Arvore):- Nivel = 1, pai_mae(Individuo, Arvore).
arvore(Nivel, Individuo, [Individuo,Arvore]):-
	Cont is  Nivel - 1,
	arvore(Cont, Individuo, [Individuo1,Individuo2]),
	arvore(Cont, Individuo1, Arvore1),
	arvore(Cont, Individuo2, Arvore2),
	concatenarLista([Individuo1,Individuo2],Arvore1, Arvore3),
	concatenarLista(Arvore3, Arvore2, Arvore).

/*arvore(Inicio, Final, Individuo, Arvore):-
	pai_mae(Individuo, [Individuo1, Individuo2]),
	Num is Inicio + 1,
	arvore(Num, Final, Individuo1, Arvore1),
	arvore(Num, Final, Individuo2, Arvore2),
	concatenarLista(Arvore1, Arvore2, Arvore).*/


%teste ([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]])
teste(X):-
	write('Digite algo:'), read(X).






























































