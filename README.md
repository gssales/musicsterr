# musicsterr
Musicsterr Mctext Music 2000: o novo gerador de música

## Partes do Programa
#### Entrada de texto
O usuário deve poder manipular o texto das seguintes formas:
- Editar o texto diretamente em uma caixa de texto
- Carregar texto de um arquivo `.txt` (fazendo *append* no texto atual)
- Salvar o texto atual em um arquivo `.txt`, nomeando caminho e nome

#### Interpretação
Depois que o texto de entrada estiver pronto, de acordo com um dicionário de regras, o texto vai ser traduzido para *Staccato*.
Essa é a linguagem que o *JFugue* usa modelar música.

#### Regras de Mapeamento
Texto | Informação Musical ou Ação
------------ | -------------
A | Nota Lá
B | Nota Si
C | Nota Dó
D | Nota Ré
E | Nota Mi
F | Nota Fá
G | Nota Sol
a,b,c,d,e,f,g | Se caractere anterior era nota, repete; Senão, silêncio ou pausa
Outra consoante | Se caractere anterior era nota, repete; Senão, silêncio ou pausa
Outra vogal | Trocar instrumento para MIDI #7 (Harpsichord)
! | Trocar instrumento para MIDI #114 (Agogo)
\n | Trocar instrumento para MIDI #15 (Tubular Bells)
; | Trocar instrumento para MIDI #76 (Pan Flute)
, | Trocar instrumento para MIDI #20 (Church Organ)
0-9 | Trocar instrumento para MIDI #atual+dígito
? ou . | Aumenta oitava; Se não puder, volta à oitava default
Espaço | Dobra volume; Se não puder aumentar, volta ao volume default
ELSE | Se caractere anterior era nota, repete; Senão, silêncio ou pausa

#### Saída de Música
Agora com a string final em *Staccato* pronta, basta usar os métodos do *JFugue* para entregar a música para o usuário:
- Tocar a música
- Salvar a música em arquivo `MIDI`, nomeando caminho e nome
