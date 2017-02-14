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

%calvice(geneP, geneM, sexo, fenótipo)
calvice('C', 'C', _, 'sim').
calvice('C', 'c', 'masculino', 'sim').
calvice('c', 'C', 'masculino', 'sim').
calvice('C', 'c', 'feminino', 'nao').
calvice('c', 'C', 'feminino', 'nao').
calvice('c', 'c', _, 'nao').

%corOlho(geneP1, geneM1, geneP2, geneM2, fenótipo)
corOlho('BM', _, _, _, 'castanho').
corOlho(_, 'BM', _, _, 'castanho').
corOlho('BA', 'BA', 'GV', _, 'verde').
corOlho('BA', 'BA', _, 'GV', 'verde').
corOlho('BA', 'BA', 'GA', 'GA', 'azul').

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

%Tipo sangue

listaSangue([[X,Y]], [Fenotipo]):- tipoSanguineo(X, Y, Fenotipo).
listaSangue([[X,Y]|Lista1], [Fenotipo|Lista2]):-
	listaSangue(Lista1, Lista2), tipoSanguineo(X, Y, Fenotipo).

retornaFenotipoSanguineo(GeneP, GeneM, Lista):-
	pareamentoGenes(GeneP, GeneM, Lista2), listaSangue(Lista2, Lista).

probabilidadeSanguineo(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoSanguineo(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

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


%teste
teste(X):-
	write('Digite algo:'), read(X).






























































