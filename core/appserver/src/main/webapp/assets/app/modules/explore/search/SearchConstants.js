/**
 * @author shuchun.yang
 * @since 1
 */
var BASE_URL = 'http://localhost:8091/';
export default {
	SEARCH_NEARBY_URL: BASE_URL + 'service/address/searchNearby/{latitude}/{longitude}',
	SEARCH_ZIPCODE_URL: BASE_URL + 'service/address/searchZipcode/{0}',
	SEARCH_NEARBY: 'SEARCH_NEARBY',
	SEARCH_ZIPCODE: 'SEARCH_ZIPCODE'
}