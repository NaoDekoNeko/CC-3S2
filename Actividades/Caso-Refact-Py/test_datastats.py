
import json

from datastats import DataStats


def test_json():
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
