import math
import json

class DataStats:
  
  def _salario_promedio(self, data):
    return math.floor(sum([int(e['salario'][1:]) for e in data])/len(data))

  def _edad_promedio(self, data):
    return math.floor(sum([e['edad'] for e in data])/len(data))

  def _incremento_anual_promedio(self, data, iedad, isalario):
    
    incremento_edad_promedio = math.floor(
            sum([e['edad'] for e in data])/len(data)) - iedad
    incremento_salario_promedio = math.floor(
            sum([int(e['salario'][1:]) for e in data])/len(data)) - isalario

    return math.floor(incremento_salario_promedio/incremento_edad_promedio)
  
  def _max_salario(self, data):
    salarios = [int(e['salario'][1:]) for e in data]
    limite = '$' + str(max(salarios))

    return [e for e in data if e['salario'] == limite]

  def _min_salario(self, data):
    salarios = [int(d['salario'][1:]) for d in data]
    return [e for e in data if e['salario'] ==
                '${}'.format(str(min(salarios)))]
  
  
  def _stats(self, data, iedad, isalario):
    return {
            'edad_promedio': self._edad_promedio(data),
            'salario_promedio': self._salario_promedio(data),
            'incremento_anual_promedio': self._incremento_anual_promedio(
                data, iedad, isalario),
            'max_salario': self._max_salario(data),
            'min_salario': self._min_salario(data)
        }

  def stats(self, data, iedad, isalario):
    return json.dumps(
      self._stats(data, iedad, isalario)
  )
