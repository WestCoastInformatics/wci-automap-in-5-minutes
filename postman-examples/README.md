# Automap in 5 Minutes: Postman Tutorial

This tutorial shows how to use Postman to interact with the WCI Automap API.

Prerequisites
-------------
* Install Postman with support for importing a v2.1 collection.
* Import [Automap-Postman-Client.json](Automap-Postman-Client.json) using File -> Import.
* The collection defaults `API_URL` to `https://automap.terminology.tools`. To change it in Postman, edit the collection, select the Variables tab, change the value, and click Update.

Automated Check
---------------
The repo can run the collection from the command line with Newman. Install Node.js so `npx` exists, or install Newman directly with:

```bash
npm install -g newman
```

Set credentials in the same terminal window before running the check. Replace `<username>` and `<password>` with your Automap username and password, without the angle brackets.

For bash or zsh:

```bash
export AUTOMAP_USER=<username>
export AUTOMAP_PASSWORD=<password>
```

For Windows PowerShell:

```powershell
$env:AUTOMAP_USER="<username>"
$env:AUTOMAP_PASSWORD="<password>"
```

Then run:

```bash
python postman_check.py
```

From the project root, this is also available as:

```bash
make check-postman
```

If you already have a bearer token, set `AUTOMAP_TOKEN` or `TOKEN` instead of username/password. The runner injects the bearer token into a temporary collection file, runs Newman, injects `API_URL`, captures the audited `taskId` and `termId` for the audit request, and deletes the temporary files after the run. It does not print access tokens.

Manual Login
------------
After importing the collection, if you choose a request and click Send before logging in, you should see this:

```json
{
    "local": false,
    "code": 401,
    "description": "Unauthorized",
    "message": "Unauthorized"
}
```

This message means you need to log in and acquire an access token. To do so:

1. Click the collection itself, "Automap Postman Client".
2. Click the Authorization tab.
3. Scroll to Configure New Token and enter:
   - Grant Type = Password Credentials
   - Access Token URL = `https://automap.terminology.tools/auth/token`
   - Username = your email username
   - Password = your password
4. Click Get New Access Token.
5. After Postman reports success, click through to Manage Access Tokens.
6. Click Use Token.

Sample Postman Calls
--------------------
When the collection is loaded into Postman, you will see requests matching the scenarios from the top-level README. Choose any request and click Send to see the result.
