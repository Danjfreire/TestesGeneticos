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
calvice('C', 'C', 'masculino', 'sim').
calvice('C', 'C', 'feminino', 'sim').
calvice('C', 'c', 'masculino', 'sim').
calvice('c', 'C', 'masculino', 'sim').
calvice('C', 'c', 'feminino', 'não').
calvice('c', 'C', 'feminino', 'não').
calvice('c', 'c', 'masculino', 'não').
calvice('c', 'c', 'feminino', 'não').


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

idPeleB(1, 'B').
idPeleB(2, 'b').

%Operacoes

removerTodos(Elem, [Elem], []).
removerTodos(_, [Elem], [Elem]).
removerTodos(Elem, [Elem|Lista1], Lista2):-
	removerTodos(Elem, Lista1, Lista2).
removerTodos(Elem1, [Elem2|Lista1], [Elem2|Lista2]):-
	removerTodos(Elem1, Lista1, Lista2).

%listaDiferente([Elem,Elem],[Elem]).
%listaDiferente([Elem1,Elem2], [Elem1,Elem2]).
listaDiferente([],[]).
listaDiferente([Elem|Lista1], [Elem|Lista]):-
	member(Elem, Lista1), removerTodos(Elem, Lista1, Lista2),
	listaDiferente(Lista2,Lista).
listaDiferente([Elem|Lista1], [Elem|Lista]):-
	listaDiferente(Lista1,Lista).

itemPorcentagem(Lista, [Elem], [[Elem,Z]]):-tamanhoLista(Lista,X), tamanhoListaEspecial(Lista, Elem, Y),
	Z is( Y/X)*100.
itemPorcentagem(Lista1, [Elem|Lista2], [[Elem,Z]|Lista]):-
	tamanhoLista(Lista1,X), tamanhoListaEspecial(Lista1, Elem, Y),
	Z is( Y/X)*100, itemPorcentagem(Lista1,  Lista2, Lista).

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
tamanhoListaEspecial([_], _, 0)/*:- Elem1 =\= Elem2*/.
tamanhoListaEspecial([Head|Tail], Head, Soma):-
	tamanhoListaEspecial(Tail, Head, Soma1), Soma is Soma1 + 1.
tamanhoListaEspecial([_|Tail], Head2, Soma):-
	tamanhoListaEspecial(Tail, Head2, Soma1), /*Head1 =\= Head2,*/ Soma is Soma1 + 0.

aleatorio2(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 2)+1.
aleatorio3(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 3)+1.
aleatorio4(Num):-
	random(X), Y is X*10000, round(Y, Z), Num is (Z mod 4)+1.

%Tipo sangue

listaSangue([[X,Y]], [Fenotipo]):- tipoSanguineo(X, Y, Fenotipo).
listaSangue([[X,Y]|Lista1], [Fenotipo|Lista2]):-
	listaSangue(Lista1, Lista2), tipoSanguineo(X, Y, Fenotipo).

retornaFenotipoSanguineo(GeneP, GeneM, Tipos):-
	pareamentoGenes(GeneP, GeneM, Lista2), listaSangue(Lista2, Tipos).

probabilidadeSanguineo(GeneP, GeneM, Fenotipo, Percentual):-
	retornaFenotipoSanguineo(GeneP, GeneM, Lista), tamanhoLista(Lista, Tamanho1),
	tamanhoListaEspecial(Lista, Fenotipo, Tamanho2), Percentual is (Tamanho2 * 100) / Tamanho1.

gerarGeneSangue([Alelo1,Alelo2], [[Alelo1, X],[Alelo2, Y]]):-
	aleatorio3(Num1), idSangue(Num1, X),
	aleatorio3(Num2), idSangue(Num2, Y).

probabilidadeSangueNome(Pai, Mae, Fenotipo, Percentual):- %absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [Gene1|_]), consultaPessoa(Mae, Destino, [Gene2|_]),
	probabilidadeSanguineo(Gene1, Gene2, Fenotipo, Percentual).

probabilidadeSangueTodos(Pai, Mae, Lista):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [Gene1|_]), consultaPessoa(Mae, Destino, [Gene2|_]),
	retornaFenotipoSanguineo(Gene1, Gene2, Tipos), itemPorcentagem(Tipos, Tipos, Lista1),
	listaDiferente(Lista1,Lista).

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

probabilidadeCalvicieNome(Pai, Mae, Fenotipo, Percentual):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,[G1,G2,_]|_]), consultaPessoa(Mae, Destino, [_,[G3,G4,_]|_]),
	probabilidadeCalvice([G1,G2],[G3,G4], Fenotipo, Percentual).

probabilidadeCalvicieTodos(Pai, Mae, Lista):-absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,[G1,G2,_]|_]), consultaPessoa(Mae, Destino, [_,[G3,G4,_]|_]),
	retornaFenotipoCalvice([G1,G2], [G3,G4], Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2, Lista).

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

probabilidadeOlhoNome(Pai, Mae, Fenotipo, Percentual):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,_,[O1,O2,O3,O4],_]), consultaPessoa(Mae, Destino, [_,_,[O5,O6,O7,O8],_]),
	probabilidadeOlho([O1,O2], [O3,O4], [O5,O6], [O7,O8], Fenotipo, Percentual).

probabilidadeOlhoTodos(Pai, Mae, Lista):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,_,[O1,O2,O3,O4],_]), consultaPessoa(Mae, Destino, [_,_,[O5,O6,O7,O8],_]),
	retornaFenotipoOlho([O1,O2],[O3,O4],[O5,O6],[O7,O8],Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2,Lista).

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

probabilidadePeleNome(Pai, Mae, Fenotipo, Percentual):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,_,_,[P1,P2,P3,P4]]), consultaPessoa(Mae, Destino, [_,_,_,[P5,P6,P7,P8]]),
	probabilidadePele([P1,P2],[P3,P4],[P5,P6],[P7,P8], Fenotipo, Percentual).

probabilidadePeleTodos(Pai, Mae, Lista):-%absolute_file_name('pessoas.txt',Destino),
	consultaPessoa(Pai, Destino, [_,_,_,[P1,P2,P3,P4]]), consultaPessoa(Mae, Destino, [_,_,_,[P5,P6,P7,P8]]),
	retornaFenotipoPele([P1,P2],[P3,P4],[P5,P6],[P7,P8], Lista1), itemPorcentagem(Lista1, Lista1, Lista2),
	listaDiferente(Lista2, Lista).

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

gerarPais([Individuo], Pais):- pai_mae(Individuo, Pais).
gerarPais([Individuo|Individuos], Pais):-
	gerarPais(Individuos, PM2),
	pai_mae(Individuo, PM1),
	concatenarLista(PM1,PM2, Pais).

preArvore(Nivel, Filhos, Arvore):- tamanhoLista(Filhos, X),  Y is 2^(Nivel - 1),
	Y = X, gerarPais(Filhos, Arvore).
preArvore(Nivel, Pessoa, Arvore):-
	gerarPais(Pessoa, Pais),
	preArvore(Nivel, Pais, SubArvore),
	concatenarLista(Pais, SubArvore, Arvore).

arvoreGenealogica(Pessoa, Arvore):- preArvore(4, [Pessoa], SubArvore), concatenarLista([Pessoa],SubArvore, Arvore1),
	reverse(Arvore1,Arvore).

%Descendentes até um nivel dado

geneFilho([Alelo1,_], [Alelo2, _], [Alelo1,Alelo2], Z):- Z = 1.
geneFilho([Alelo1,_], [_, Alelo2], [Alelo1,Alelo2], Z):- Z = 2.
geneFilho([_,Alelo1], [Alelo2, _], [Alelo1,Alelo2], Z):- Z = 3.
geneFilho([_,Alelo1], [_, Alelo2], [Alelo1,Alelo2], Z):- Z = 4.

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

listaFilhos(Pai, Mae, Quantidade, [Filho]):- Quantidade = 1, gerarFilho(Pai, Mae, Filho).
listaFilhos(Pai, Mae, Quantidade, [Filho|Filhos]):-
	Resto is Quantidade - 1, listaFilhos(Pai, Mae, Resto, Filhos),
	gerarFilho(Pai, Mae, Filho).

listaFilhas(Pai, Mae, Quantidade, [Filha]):- Quantidade = 1, gerarFilha(Pai, Mae, Filha).
listaFilhas(Pai, Mae, Quantidade, [Filha|Filhas]):-
	Resto is Quantidade - 1, listaFilhas(Pai, Mae, Resto, Filhas),
	gerarFilha(Pai, Mae, Filha).

tiraUlt([_],[]).
tiraUlt([Cabeca|Cauda], [Cabeca|Lista]):-
	tiraUlt(Cauda, Lista).

removerLista(Lista1, 1, Lista2):- tiraUlt(Lista1, Lista2).
removerLista([_|Lista], Num1, Lista):- tamanhoLista([_|Lista], Num2), Num1 = Num2.
removerLista([Head1|Cauda1], Indice, [Head1|Cauda2]):-
	removerLista(Cauda1, Indice, Cauda2).

retornaUlt([Ultimo], Ultimo).
retornaUlt([_|Cauda], Ultimo):-
	retornaUlt(Cauda, Ultimo).

pegarLista(Lista, 1, Elemento):- retornaUlt(Lista, Elemento).
pegarLista([Cabeca|Cauda], Indice, Cabeca):-
	tamanhoLista([Cabeca|Cauda], X), Indice = X.
pegarLista([_|Cauda], Indice, Elemento):-
	pegarLista(Cauda, Indice, Elemento).

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

filhosCasais([[[Homem,_],[Mulher,_]]],[Filhos,Filhas]):-
	aleatorio2(X), listaFilhos(Homem, Mulher, X, Filhos),
	listaFilhas(Homem, Mulher, X, Filhas).
filhosCasais([[[Homem,_], [Mulher,_]]|Casais], [Filhos, Filhas]):-
	aleatorio2(X), listaFilhos(Homem, Mulher, X, Filhos1),
        listaFilhas(Homem, Mulher, X, Filhas1),
	filhosCasais(Casais, [Filhos2, Filhas2]),
	concatenarLista(Filhos1, Filhos2, Filhos),
	concatenarLista(Filhas1, Filhas2, Filhas).

preDescendentes(Casais, [Descendentes], 1):- filhosCasais(Casais, Descendentes).
preDescendentes(Casal, [Casais|Descendentes], Nivel):-
	filhosCasais(Casal,[Filhos,Filhas]),
	formarCasais(Filhos, Filhas, Casais),
	Resto is Nivel - 1,
	preDescendentes(Casais, Descendentes, Resto).

descendentes(Homem, Mulher, Descendentes, Nivel):-
	preDescendentes([[[Homem,_], [Mulher,_]]], Descendentes, Nivel).


%insercao e consulta

vazio('').

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

%testes
teste([1,[2,[3]]]).


















































