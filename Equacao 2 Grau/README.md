# Equacao_2_Grau
1 ) Faça um programa em java que resolva equações do segundo grau. O programa deve obedecer as seguintes especificações:
#### EGrau2:
+ a,b,c: double

+ EGrau2(double, double, double)
+ delta():double
+ calculaX1(double):double
+ calculaX2(double):double

#### Main
+ exibe(double, double):String
+ le(int):double
+ main():void

A função le( ) deve conter um texto dinâmico que seja válido tanto para ler o
coeficiente A quanto os coeficientes B e C. Para o coeficiente A, deve-se dizer que o
valor dele precisa ser diferente de zero. A leitura do coeficiente A deve ser validada no
main( ).

Caso o valor do delta seja menor que zero, deve-se exibir uma mensagem de erro
dizendo que não é possível calcular raízes reais e assim finalizar o programa.
Após exibir as raízes da equação, deve-se perguntar ao usuário se ele deseja resolver
uma nova equação do segundo grau. Se sim, repita o processo, caso contrário, finalize
o programa.
