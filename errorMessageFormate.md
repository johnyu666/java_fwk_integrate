# Twitter

{
	"errors": [
		{
		"message": "Sorry, that page does not exist",
		"code": 34
		}
	]
}

# Facebook

{
	"error": {
		"message": "Message describing the error",
		"type": "OAuthException",
		"code": 190,
		"error_subcode": 460,
		"error_user_title": "A title",
		"error_user_msg": "A message",
		"fbtrace_id": "EJplcsCHuLu"
	}
}

# Google (use http status)

{
	"error": {
		"errors": [
			{
			"domain": "global",
			"reason": "insufficientFilePermissions",
			"message": "The user does not have sufficient permissions for file {fileId}."
			}
		],
		"code": 403,
		"message": "The user does not have sufficient permissions for file {fileId}."
	}
}

# Github 

{
	"message": "Validation Failed",
	"errors": [
		{
		"resource": "Issue",
		"field": "title",
		"code": "missing_field"
		}
	]
}









