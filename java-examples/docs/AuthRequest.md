

# AuthRequest

Represents info for an authentication request.

## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**username** | **String** | the username |  [optional] |
|**password** | **String** | the password |  [optional] |
|**token** | **String** | the token (for a refresh flow) |  [optional] |
|**refreshToken** | **String** | the refresh token (for a refresh flow) |  [optional] |
|**grantType** | [**GrantTypeEnum**](#GrantTypeEnum) |  |  |



## Enum: GrantTypeEnum

| Name | Value |
|---- | -----|
| USERNAME_PASSWORD | &quot;username_password&quot; |
| PASSWORD | &quot;password&quot; |
| AUTHORIZATION_CODE | &quot;authorization_code&quot; |



