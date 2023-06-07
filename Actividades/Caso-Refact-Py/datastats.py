
import math
import json


class DataStats:
  def stats(self, data, iedad, isalario):
    incremento_edad_promedio = math.floor(sum([e['edad'] for e in data])/len(data)) - iedad
    incremento_salario_promedio = math.floor( sum([int(e['salario'][1:]) for e in data])/len(data)) - isalario

    incremento_anual_promedio = math.floor(incremento_salario_promedio/incremento_edad_promedio)

    salarios = [int(e['salario'][1:]) for e in data]
    limite = '$' + str(max(salarios))

    max_salario = [e for e in data if e['salario'] == limite]

    salarios = [int(d['salario'][1:]) for d in data]
    min_salario = [e for e in data if e['salario'] ==
                      '${}'.format(str(min(salarios)))]

    return json.dumps({
        'edad_promedio': math.floor(sum([e['edad'] for e in data])/len(data)),
        'salario_promedio': math.floor(sum( [int(e['salario'][1:]) for e in data])/len(data)),
        'incremento_anual_promedio': incremento_anual_promedio,
        'max_salario': max_salario,
        'min_salario': min_salario
        })
