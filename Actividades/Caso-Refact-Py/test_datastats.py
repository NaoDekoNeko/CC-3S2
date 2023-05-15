
import json

from datastats import DataStats

test_data = [
        {
          "id": 1,
          "nombre": "Irene",
          "apodo": "Lara",
          "edad": 68,
          "salario": "$27888" 
        },
       
       {
           "id": 2,
          "nombre": "Claudio",
          "apodo": "Avila",
          "edad": 49,
          "salario": "$67137"
      },
      {
          "id": 3,
          "nombre": "Tomo",
          "apodo": "Frugs",
          "edad": 70,
          "salario": "$70472"
      }
    ]

def test_json():
  
  ds = DataStats()

  assert ds.stats(test_data, 20, 20000) == json.dumps(
        {
            "edad_promedio": 62,
            "salario_promedio": 55165,
            "incremento_anual_promedio": 837,
            "max_salario": [{
                 "id": 3,
                  "nombre": "Tomo",
                  "apodo": "Frugs",
                  "edad": 70,
                  "salario": "$70472"
           }],
          "min_salario": [{
              "id": 1,
              "nombre": "Irene",
              "apodo": "Lara",
              "edad": 68,
              "salario": "$27888"
            }]
       }
    )
        

def test__stats():

   ds = DataStats()
   
   assert ds._stats(test_data, 20, 20000) == {
        "edad_promedio": 62,
        "salario_promedio": 55165,
        "incremento_anual_promedio": 837,
        "max_salario": [{
            "id": 3,
            "nombre": "Tomo",
            "apodo": "Frugs",
             "edad": 70,
              "salario": "$70472"
    }],
    "min_salario": [{
        "id": 1,
        "nombre": "Irene",
        "apodo": "Lara",
        "edad": 68,
        "salario": "$27888"
        
        }]
    }

def test__edad_promedio():
  ds = DataStats()
  assert ds._edad_promedio(test_data) == 62

def test__salario_promedio():
  ds = DataStats()
  assert ds._salario_promedio(test_data) == 55165

def test__incremento_anual_promedio():
  ds = DataStats()
  assert ds._incremento_anual_promedio(test_data, 20, 20000) == 837


def test__max_salario():  
  ds = DataStats()
  
  assert ds._max_salario(test_data) == [{
        "id": 3,
          "nombre": "Tomo",
          "apodo": "Frugs",
          "edad": 70,
          "salario": "$70472"
    }]

def test__min_salario():
  ds = DataStats()
  assert ds._min_salario(test_data) ==[{
      "id": 1,
      "nombre": "Irene",
      "apodo": "Lara",
      "edad": 68,
      "salario": "$27888"
       }]
