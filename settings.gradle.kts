rootProject.name = "MaisForte"

include(
    "services:auth-service",
    "services:account-service",
    "services:training-service",
    "shared:common",
    "shared:http",
    "shared:logging",
    "shared:security",
    "bff-app",
    "bff-web"
)
