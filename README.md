# WCI Automap in 5 Minutes Tutorial

This is an easy-to-use tutorial for accessing WCI Automap APIs through automap.terminology.tools.
[WCI Automap](https://www.westcoastinformatics.com/products/mapping) healthcare data 
standardization/normalization platform that takes data in a variety of forms and performs
AI-assisted terminology linking.  

This system supports use cases including
* Automated mapping between local coding systems and standards 
* Automated mapping between standard coding systems
* Checking that codes used in data are active and valid in current verisons of coding systems
* Updating retired codes through history mechanisms to verison codes
* Linking of snippets of clinical text to standard terminology codes

[Tutorial Training Video](https://youtu.be/TBD)

**Reference deployments**

To test against our Automap server, you will need a username/password account in our 
reference depoyment server at https://automap-ui.terminology.tools.  To request an
account, send email to info@westcoastinformatics.com.

## Table of Contents

1. [Tutorials by Language](#tutorials-by-language)
2. [Use Cases](#use-cases)
3. [Resources](#resources)
4. [Contributing](#contributing)
5. [License](#license)

## Tutorials by Language

- [Click for Curl examples.](../master/curl-examples/ "Curl Examples")
- [Click for Postman examples.](../master/postman-examples/ "Postman Examples")
- [Click for Java examples.](../master/java-examples/ "Java Examples")


**[Back to top](#table-of-contents)**

## Use Cases

The following cases will be used to demonstrate accessing the WCI Automap API.  These include
access to metadata and config information as well as various modes of requesting mappings to be
performed as individual or batch calls and how to search and retrieve results after the fact.

- Login
- Get entity configuration
- Get application metadata
- Get version information for components of the application
- Map from a starting terminology and code
- Map from a starting terminology and inactive code
- Map from a starting terminology and invalid code
- Map from a simple bodyPart text string
- Map from a simple condition text string
- Map from a simple labResult text string
- Map from a simple medication text string
- Map from a simple procedure text string
- Map from a complex text string
- Map from a simple text string without specifying entity type
- Map from a simple text string with extra tagging information
- Map from a simple text string with auditing and retrieve audit trail
- Find tasks
- Find terms

All of the tutorials use an environment variable for the API URL of the deployment:

- API_URL=https://automap.terminology.tools

**[Back to top](#table-of-contents)**


## Resources

- API Documentation - https://automap.terminology.tools/swagger-ui/index.html

**[Back to top](#table-of-contents)**

## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

**[Back to top](#table-of-contents)**

## Current Contributors

- [Brian Carlsen](https://github.com/bcarlsenca)
- [Other Contributors](https://github.com/WestCoastInformatics/termhub-in-5-minutes/graphs/contributors)

**[Back to top](#table-of-contents)**

## License

See the included [`LICENSE.txt`](LICENSE.txt) file for details.

**[Back to top](#table-of-contents)**

