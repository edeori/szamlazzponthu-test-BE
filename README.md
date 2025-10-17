# szamlazzponthu-test-BE

# Docker build
docker build -t szamlazzponthu-test-app:latest .

# Fejlesztési workflow
Mivel főleg backend és java heavy a tudásom, így ezzel a kóddal sok segítség nem kellett.
Néhány helyre generáltattam boilerplate helyett, illetve a specifikáció alapján a ChatGPT-vel készíttettem el az openapi.yaml fileomat. Ezt utána kézzel is szerkesztettem.
Debugolás során egyszer volt szükség arra, hogy AI segítséggel oldjak fel egy H2 db problémát, mert ritkán használok megvalósításhoz in-memory db-t és összeakadt a hibernate jpa-val egy helyen (nincs RETURNING H2-ben).
Rossz helyre raktam először a repackage buildet, és ehhez kértem még egyszer a ChatGPT-től debug segítséget a pom filejaimon.