/*
 * Harmony Connect
 * An easy to use API that helps you access the Factom blockchain.
 *
 * OpenAPI spec version: 1.0.17
 * Contact: harmony-support@factom.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package harmony_connect_client.api;

import harmony_connect_client.*;
import harmony_connect_client.auth.*;
import harmony_connect_client.model.*;
import harmony_connect_client.ApiException;
import harmony_connect_client.model.Chain;
import harmony_connect_client.model.ChainCreate;
import harmony_connect_client.model.ChainList;
import harmony_connect_client.model.ChainShort;
import harmony_connect_client.model.Entry;
import harmony_connect_client.model.EntryCreate;
import harmony_connect_client.model.EntryList;
import harmony_connect_client.model.EntrySearchResponse;
import harmony_connect_client.model.EntryShort;
import harmony_connect_client.model.SearchBody;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.BeforeClass;
import org.junit.Assert;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * API tests for EntriesApi
 */
public class EntriesApiTest {
    static EntriesApi api;
    static String testChainId;
    static String testEntryHash;
    static String secondTestEntryHash;
    String timeNonce = Base64.getEncoder().encodeToString((System.currentTimeMillis()+"").getBytes());
    String testExtId = "ZXhhbXBsZS1leHRpZA==";

    private static class SetUpResults {
        String testChainId;
        String testEntryHash;
        ChainsApi chainsApi;
        EntriesApi entriesApi;
    }

    @BeforeClass
    public static void setUp() {
        EntriesApiTest obj = new EntriesApiTest();
        SetUpResults setupResults = obj.setUpHelper();
        api = setupResults.entriesApi;
        testChainId = setupResults.testChainId;
        testEntryHash = setupResults.testEntryHash;
    }

    public SetUpResults setUpHelper() {
        InputStream inputStream = null;
        String baseurl;
        String appid;
        String appkey;
        EntriesApi newEntriesApi = null;
        ChainsApi newChainsApi = null;
        String newTestChainId = "";
        String newTestEntryHash = "";

		try {
			Properties prop = new Properties();

			inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("config.properties file not found in the classpath");
			}

			baseurl = prop.getProperty("baseurl");
			appid = prop.getProperty("appid");
            appkey = prop.getProperty("appkey");

            ApiClient defaultClient = Configuration.getDefaultApiClient();
            defaultClient.setBasePath(baseurl);
            ApiKeyAuth AppId = (ApiKeyAuth) defaultClient.getAuthentication("AppId");
            AppId.setApiKey(appid);
            ApiKeyAuth AppKey = (ApiKeyAuth) defaultClient.getAuthentication("AppKey");
            AppKey.setApiKey(appkey);
            newEntriesApi = new EntriesApi();
            newChainsApi = new ChainsApi();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }

        ChainCreate chainCreate = new ChainCreate();
        List<String> externalIds = Arrays.asList(testExtId, timeNonce);
        String content = "ZXhhbXBsZS1jb250ZW50";
        chainCreate.externalIds(externalIds);
        chainCreate.content(content);
        try {
            ChainShort response = newChainsApi.postChain(chainCreate);
            newTestChainId = response.getChainId();
            newTestEntryHash = response.getEntryHash();
            assertFalse(newTestChainId.isEmpty());
        } catch (Exception e) {
			System.out.println("Exception: " + e);
        }

        SetUpResults result = new SetUpResults();
        result.entriesApi = newEntriesApi;
        result.chainsApi = newChainsApi;
        result.testChainId = newTestChainId;
        result.testEntryHash = newTestEntryHash;
        return result;
    }

    /**
     * Get Chain's Entries
     *
     * List all entries contained on the specified chain.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEntriesByChainIDTest() throws ApiException {
        EntryList response = api.getEntriesByChainID(testChainId, 10, 0, "replicated");

        assertFalse(response.toString().isEmpty());

        Boolean foundTestEntry = false;

        for (EntryListData dataItem : response.getData()) {
            if (dataItem.getEntryHash().equals(testEntryHash)) {
                foundTestEntry = true;
            }
        }
        assertTrue(foundTestEntry);
    }
    
    /**
     * Get Entry Info
     *
     * Returns information about a specific entry on Connect. The requested entry must be specified using the Chain ID and Entry Hash.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getEntryByHashTest() throws ApiException {
        Entry response = api.getEntryByHash(testChainId, testEntryHash);

        assertFalse(response.toString().isEmpty());
        assertEquals("entry hash should match", testEntryHash, response.getData().getEntryHash());
    }
    
    /**
     * Get Chain's First Entry
     *
     * Retrieve the first entry that has been saved to this chain.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getFirstEntryTest() throws ApiException {
        Entry response = api.getFirstEntry(testChainId);

        assertFalse(response.toString().isEmpty());
        assertEquals("entry hash should match", testEntryHash, response.getData().getEntryHash());
    }
    
    /**
     * Get Chain's Last Entry
     *
     * Retrieve the last entry that has been saved to this chain.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLastEntryTest() throws ApiException {
        Entry response = api.getLastEntry(testChainId);

        assertFalse(response.toString().isEmpty());
        if (!response.getData().getEntryHash().equals(testEntryHash)) {
            assertEquals("entry hash should match", secondTestEntryHash, response.getData().getEntryHash());
        }
    }
    
    /**
     * Search Chain's Entries
     *
     * Find all of the entries within the specified chain that have the requested &#x60;external_ids&#x60;.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postEntriesSearchTest() throws ApiException {
        SearchBody searchBody = new SearchBody();
        searchBody.addExternalIdsItem(testExtId);
        EntrySearchResponse response = api.postEntriesSearch(testChainId, searchBody, 10, 0);

        assertFalse(response.toString().isEmpty());
        assertTrue(response.getData().size() > 0);
    }
    
    /**
     * Create an Entry
     *
     * Create a new entry for the selected chain. Content and external id must be uploaded in Base64 format.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void postEntryToChainIDTest() throws ApiException {
        EntryCreate entryCreate = new EntryCreate();
        entryCreate.addExternalIdsItem("c2Vjb25kLWVudHJ5");
        entryCreate.content("c2Vjb25kLWVudHJ5LWNvbnRlbnQ=");
        EntryShort response = api.postEntryToChainID(testChainId, entryCreate);

        assertFalse(response.toString().isEmpty());
        secondTestEntryHash = response.getEntryHash();
    }
    
}
