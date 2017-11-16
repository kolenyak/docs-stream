Tanto o stream() ou parallelStream() são usados para executar operações de forma mais rápida e porque não, de forma mais elegante, reduzindo a quantidade de código e o deixando menos verboso, a diferença está modo como será executado, enquanto stream() executa as operações de forma sequencial, o parallelStream() irá criar divisões das operações para rodarem ao mesmo tempo através de outras threads e no final junta-lás.

A utilização do parallelStream() é indicada quando o sistema é executado em computadores com vários processadores ou núcleos, onde cada parte da operação pode ser executada e quando não é necessário manter uma ordem de execução.

Já quando precisamos manter uma sequência obrigatório devido a implementação de alguma regra o stream() é o mais indicado

Claro que usar um ou outro não é garantia de performance final, sempre é bom testar como estão os tempos quando usando tanto o loops-for, stream() e com parallelStream().

### Exemplo de utilização e tempo de execução

> No projeto tem uma classe Teste.java com exemplo de execução para cada um, 
> porém foram executados separados para não influenciar algum cache do objeto 
> Array ou Integer

Ao executar um método por vez o tempo varia bastante, já que independente se são operações são pequenas ou grandes ainda é necessário a complição em bytescodes, para depois roda-los

*O Computador também conta nessas horas...

LOOP-FOR: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
LOOP-FOR: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
TEMPO: 0 ms.

PARALLEL STREAM: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
PARALLEL STREAM: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
TEMPO: 31 ms.

STREAM: [1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
STREAM: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
TEMPO: 47 ms.



