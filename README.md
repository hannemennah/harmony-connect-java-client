# harmony-connect-client

Harmony Connect
- API version: 1.0.17
  - Build date: 2019-02-19T17:12:36.829940300-06:00[America/Chicago]

An easy to use API that helps you access the Factom blockchain.

  For more information, please visit [https://docs.harmony.factom.com](https://docs.harmony.factom.com)

*Automatically generated by the [OpenAPI Generator](https://openapi-generator.tech)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>factomProject</groupId>
  <artifactId>harmony-connect-client</artifactId>
  <version>1.0.1</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "factomProject:harmony-connect-client:1.0.1"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/harmony-connect-client-1.0.1.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import harmony_connect_client.*;
import harmony_connect_client.auth.*;
import harmony_connect_client.model.*;
import harmony_connect_client.api.ChainsApi;

import java.io.File;
import java.util.*;

public class ChainsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: AppId
        ApiKeyAuth AppId = (ApiKeyAuth) defaultClient.getAuthentication("AppId");
        AppId.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AppId.setApiKeyPrefix("Token");

        // Configure API key authorization: AppKey
        ApiKeyAuth AppKey = (ApiKeyAuth) defaultClient.getAuthentication("AppKey");
        AppKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //AppKey.setApiKeyPrefix("Token");

        ChainsApi apiInstance = new ChainsApi();
        String chainId = 285904; // String | Chain identifier
        try {
            Chain result = apiInstance.getChainByID(chainId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChainsApi#getChainByID");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://connect-shared-sandbox-2445582615332.production.gw.apicast.io/v1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ChainsApi* | [**getChainByID**](docs/ChainsApi.md#getChainByID) | **GET** /chains/{chain_id} | Get Chain Info
*ChainsApi* | [**getChains**](docs/ChainsApi.md#getChains) | **GET** /chains | Get All Chains
*ChainsApi* | [**postChain**](docs/ChainsApi.md#postChain) | **POST** /chains | Create a Chain
*ChainsApi* | [**postChainSearch**](docs/ChainsApi.md#postChainSearch) | **POST** /chains/search | Search Chains
*EntriesApi* | [**getEntriesByChainID**](docs/EntriesApi.md#getEntriesByChainID) | **GET** /chains/{chain_id}/entries | Get Chain&#39;s Entries
*EntriesApi* | [**getEntryByHash**](docs/EntriesApi.md#getEntryByHash) | **GET** /chains/{chain_id}/entries/{entry_hash} | Get Entry Info
*EntriesApi* | [**getFirstEntry**](docs/EntriesApi.md#getFirstEntry) | **GET** /chains/{chain_id}/entries/first | Get Chain&#39;s First Entry
*EntriesApi* | [**getLastEntry**](docs/EntriesApi.md#getLastEntry) | **GET** /chains/{chain_id}/entries/last | Get Chain&#39;s Last Entry
*EntriesApi* | [**postEntriesSearch**](docs/EntriesApi.md#postEntriesSearch) | **POST** /chains/{chain_id}/entries/search | Search Chain&#39;s Entries
*EntriesApi* | [**postEntryToChainID**](docs/EntriesApi.md#postEntryToChainID) | **POST** /chains/{chain_id}/entries | Create an Entry
*InfoApi* | [**getApiInfo**](docs/InfoApi.md#getApiInfo) | **GET** / | API Info


## Documentation for Models

 - [AllInfo](docs/AllInfo.md)
 - [AllInfoLinks](docs/AllInfoLinks.md)
 - [Chain](docs/Chain.md)
 - [ChainCreate](docs/ChainCreate.md)
 - [ChainData](docs/ChainData.md)
 - [ChainDataDblock](docs/ChainDataDblock.md)
 - [ChainDataEblock](docs/ChainDataEblock.md)
 - [ChainDataEntries](docs/ChainDataEntries.md)
 - [ChainLink](docs/ChainLink.md)
 - [ChainList](docs/ChainList.md)
 - [ChainListData](docs/ChainListData.md)
 - [ChainShort](docs/ChainShort.md)
 - [Entry](docs/Entry.md)
 - [EntryCreate](docs/EntryCreate.md)
 - [EntryData](docs/EntryData.md)
 - [EntryDataDblock](docs/EntryDataDblock.md)
 - [EntryDataEblock](docs/EntryDataEblock.md)
 - [EntryList](docs/EntryList.md)
 - [EntryListChain](docs/EntryListChain.md)
 - [EntryListData](docs/EntryListData.md)
 - [EntrySearchResponse](docs/EntrySearchResponse.md)
 - [EntrySearchResponseData](docs/EntrySearchResponseData.md)
 - [EntryShort](docs/EntryShort.md)
 - [SearchBody](docs/SearchBody.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### AppId

- **Type**: API key
- **API key parameter name**: app_id
- **Location**: HTTP header

### AppKey

- **Type**: API key
- **API key parameter name**: app_key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

harmony-support@factom.com

