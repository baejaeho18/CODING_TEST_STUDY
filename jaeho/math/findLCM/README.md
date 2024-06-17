|          순번          |        문제 이름         |        나의 풀이         |         난이도          |        풀이 링크         |
| :-----: | :-----: | :-----: | :-----: | :-----: |
| 00 |  <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12953" target="_blank">최소 공배수 찾기</a> | <a href="./12953">풀이</a> | <img height="25px" width="25px" src="https://static.solved.ac/tier_small/4.svg"/> | <a href="https://school.programmers.co.kr/learn/courses/30/lessons/12953/solution_groups?language=java" target="_black">정답</a> |

프로그래머스 2단계 문제 : n개의 수의 최소 공배수 구하기

각 수들의 약수를 구하고, 모든 약수를 각 약수의 가장 많은 수만큼 곱한다.

문제는 약수가 소수가되어야 하는데, 소수인지 판별해야한다는 것.
첫 시도에서는 40대까지의 소수를 미리 주었다. 이 경우 50 이상의 소수를 약수로 하는 수가 input으로 오면 반드시 오류가 날 것이다.
따라서, 1) 소수를 판별해서 array로 반환하는 함수를 추가하거나 2) input 값 이하의 모든 수를 순회하되, 이미 거친 수의 배수를 제외하도록 해도 되겠다.

