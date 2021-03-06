/*
 * Harmony Connect
 * An easy to use API that helps you access the Factom blockchain.
 *
 * OpenAPI spec version: 1.0.19
 * Contact: harmony-support@factom.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package harmony_connect_client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import harmony_connect_client.model.ABlockLongDblock;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * A single factoid block from the factom blockchain.
 */
@ApiModel(description = "A single factoid block from the factom blockchain.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2019-07-03T22:54:40.268681300Z[UTC]")
public class FBlockShort {
  public static final String SERIALIZED_NAME_KEYMR = "keymr";
  @SerializedName(SERIALIZED_NAME_KEYMR)
  private String keymr;

  public static final String SERIALIZED_NAME_HREF = "href";
  @SerializedName(SERIALIZED_NAME_HREF)
  private String href;

  public static final String SERIALIZED_NAME_DBLOCK = "dblock";
  @SerializedName(SERIALIZED_NAME_DBLOCK)
  private ABlockLongDblock dblock = null;

  public static final String SERIALIZED_NAME_EC_RATE = "ec_rate";
  @SerializedName(SERIALIZED_NAME_EC_RATE)
  private String ecRate;

  public static final String SERIALIZED_NAME_TRANSACTIONS = "transactions";
  @SerializedName(SERIALIZED_NAME_TRANSACTIONS)
  private String transactions;

  public FBlockShort keymr(String keymr) {
    this.keymr = keymr;
    return this;
  }

   /**
   * The SHA256 Hash of this entry.
   * @return keymr
  **/
  @ApiModelProperty(value = "The SHA256 Hash of this entry.")
  public String getKeymr() {
    return keymr;
  }

  public void setKeymr(String keymr) {
    this.keymr = keymr;
  }

  public FBlockShort href(String href) {
    this.href = href;
    return this;
  }

   /**
   * An API link to obtain the full set of data for this factoid block.
   * @return href
  **/
  @ApiModelProperty(value = "An API link to obtain the full set of data for this factoid block.")
  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public FBlockShort dblock(ABlockLongDblock dblock) {
    this.dblock = dblock;
    return this;
  }

   /**
   * Get dblock
   * @return dblock
  **/
  @ApiModelProperty(value = "")
  public ABlockLongDblock getDblock() {
    return dblock;
  }

  public void setDblock(ABlockLongDblock dblock) {
    this.dblock = dblock;
  }

  public FBlockShort ecRate(String ecRate) {
    this.ecRate = ecRate;
    return this;
  }

   /**
   * The Entry credit rate at the time this block was created.
   * @return ecRate
  **/
  @ApiModelProperty(value = "The Entry credit rate at the time this block was created.")
  public String getEcRate() {
    return ecRate;
  }

  public void setEcRate(String ecRate) {
    this.ecRate = ecRate;
  }

  public FBlockShort transactions(String transactions) {
    this.transactions = transactions;
    return this;
  }

   /**
   * The number of factoid transactions that occur in this block.
   * @return transactions
  **/
  @ApiModelProperty(value = "The number of factoid transactions that occur in this block.")
  public String getTransactions() {
    return transactions;
  }

  public void setTransactions(String transactions) {
    this.transactions = transactions;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FBlockShort fblockShort = (FBlockShort) o;
    return Objects.equals(this.keymr, fblockShort.keymr) &&
        Objects.equals(this.href, fblockShort.href) &&
        Objects.equals(this.dblock, fblockShort.dblock) &&
        Objects.equals(this.ecRate, fblockShort.ecRate) &&
        Objects.equals(this.transactions, fblockShort.transactions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keymr, href, dblock, ecRate, transactions);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FBlockShort {\n");
    sb.append("    keymr: ").append(toIndentedString(keymr)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    dblock: ").append(toIndentedString(dblock)).append("\n");
    sb.append("    ecRate: ").append(toIndentedString(ecRate)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

