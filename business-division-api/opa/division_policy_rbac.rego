package istio.authz

import input.attributes.request.http as http_request

default allow = false

token = {"payload": payload} {
    [_, encoded] := split(http_request.headers.authorization, " ")
    [header, payload, signature] := io.jwt.decode(encoded)
}

allow {
    action_allowed
}

action_allowed {
    some i
    http_request.method == "GET"
    #http_request.path == "/channel/division-management/v1/divisions?"
    "manage-account" == token.payload.resource_access.account.roles[i]
}