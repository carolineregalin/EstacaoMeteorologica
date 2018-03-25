Uma estação meteorológica automatizada gera um arquivo com os dados que coleta diariamente. Numa hora
programada, seus sensores captam o estado do ambiente e isto é gravado num arquivo binário, no seguinte
formato:
  Data – String com formato “dd/mm/aaaa”
  Direção do vento – char + char (N , NE, NW, S , SE, SW, E , W )
  Velocidade do vento – int (em km/h)
  Índice pluviométrico – int (em mm)
  Temperatura – double (em ⁰C)
  
Num arquivo binário podem existir dados de vários meses, porém os dados sempre estão em ordem
cronológica.
Estes dados precisam ser convertidos para um objeto correspondente, ou seja, para cada dia haverá um objeto
da classe ClimaDoDia:
Para cada mês encontrado, deve-se gerar um arquivo de objetos com os respectivos dias, cujo nome deve ser
“AAAA-MM.dat”, em que AAAA significa o ano e MM o mês.
Caso haja algum problema cronológico, como dias repetidos ou fora de ordem (a ausência de algum dia não
significa problema), o arquivo não deve ser processado e deve-se informar o problema detectado. Exemplos:
“Dia 10/03/2018 está repetido”
“Dia 11/03/2018 foi encontrado antes de 08/03/2018”
Exemplo de arquivo binário de entrada está disponível no AVA – Unidade 1.
A partir dos arquivos serializados será possível gerar um relatório textual. O usuário poderá indicar um mês
(um arquivo serializado previamente criado) e então serão efetuados os cálculos e gerado o relatório em
formato texto.

Crie um programa Java orientado a objetos que leia um arquivo da estação meteorológica (informado pelo
usuário através de uma caixa de escolha de arquivo) e gere os correspondentes arquivos de objetos. Em outro
momento o usuário poderá selecionar um arquivo de objeto e gerar o relatório em formato texto. A saída do
seu programa pode ser direcionada para uma área de texto na interface gráfica ou para um arquivo de texto.
A opção da saída é efetuada pelo usuário logo antes de iniciar a leitura do arquivo.
