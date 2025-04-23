#!/bin/bash

# Configuration
KEYCLOAK_URL="http://localhost:8080"
API_URL="http://localhost:8081"
REALM="personne-realm"
CLIENT_ID="personne-client"

# Fonction pour obtenir un token
get_token() {
    local username=$1
    local password=$2
    curl -s -X POST "$KEYCLOAK_URL/realms/$REALM/protocol/openid-connect/token" \
        -H "Content-Type: application/x-www-form-urlencoded" \
        -d "client_id=$CLIENT_ID" \
        -d "username=$username" \
        -d "password=$password" \
        -d "grant_type=password" | jq -r '.access_token'
}

# Fonction pour tester un endpoint
test_endpoint() {
    local method=$1
    local url=$2
    local token=$3
    local data=$4

    echo "Testing $method $url"
    if [ -z "$data" ]; then
        curl -X $method "$url" \
            -H "Authorization: Bearer $token" \
            -H "Content-Type: application/json"
    else
        curl -X $method "$url" \
            -H "Authorization: Bearer $token" \
            -H "Content-Type: application/json" \
            -d "$data"
    fi
    echo -e "\n"
}

# Demander les informations de connexion
echo "Entrez l'email de l'admin:"
read admin_email
echo "Entrez le mot de passe de l'admin:"
read -s admin_password
echo
echo "Entrez l'email de l'utilisateur:"
read user_email
echo "Entrez le mot de passe de l'utilisateur:"
read -s user_password
echo

# Obtenir les tokens
admin_token=$(get_token "$admin_email" "$admin_password")
user_token=$(get_token "$user_email" "$user_password")

# Tester avec l'admin
echo "=== Tests avec l'admin ==="
test_endpoint "GET" "$API_URL/api/personnes" "$admin_token"
test_endpoint "POST" "$API_URL/api/personnes" "$admin_token" '{"nom":"Test","prenom":"Admin","email":"test.admin@example.com"}'
test_endpoint "PUT" "$API_URL/api/personnes/1" "$admin_token" '{"nom":"Test","prenom":"Admin Modifié","email":"test.admin.modifie@example.com"}'
test_endpoint "DELETE" "$API_URL/api/personnes/1" "$admin_token"

# Tester avec l'utilisateur
echo "=== Tests avec l'utilisateur ==="
test_endpoint "GET" "$API_URL/api/personnes" "$user_token"
test_endpoint "POST" "$API_URL/api/personnes" "$user_token" '{"nom":"Test","prenom":"User","email":"test.user@example.com"}' 