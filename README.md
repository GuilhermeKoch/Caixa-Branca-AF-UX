# ETAPA 3

## Grafo de Fluxo

Grafo de Fluxo.png

## Complexidade Ciclomatica

E= 12 (número de arestas);
N=11 (número de nós);
P=1 (apenas um componente conectado).

Substituindo na fórmula:

M = 12 − 10 + 2 * 1
M = 4

A complexidade ciclomática do fluxo é 4
Isso significa que existem 4 caminhos lineares independentes no código. Esse valor indica a quantidade mínima de casos de teste necessários para cobrir todos os caminhos possíveis no programa.

## Caminhos Básicos

Caminho 1:

Início → conectarBD() → Conexão bem-sucedida → verificarUsuario(login, senha) → Montar consulta SQL → Executar consulta → Consulta com resultados → Fim
Caminho 2:

Início → conectarBD() → Conexão bem-sucedida → verificarUsuario(login, senha) → Montar consulta SQL → Executar consulta → Consulta sem resultados → Fim
Caminho 3:

Início → conectarBD() → Conexão bem-sucedida → verificarUsuario(login, senha) → Montar consulta SQL → Executar consulta → Exceção no SQL → Fim
Caminho 4:

Início → conectarBD() → Conexão falhou → Fim

