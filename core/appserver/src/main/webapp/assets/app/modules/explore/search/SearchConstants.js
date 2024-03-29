/**
 * @author shuchun.yang
 * @since 1
 */
export const BASE_URL = 'http://localhost:8091/';
export const SEARCH_NEARBY_URL = BASE_URL + 'service/address/searchNearby/{latitude}/{longitude}';
export const SEARCH_CITY_ZIPCODE_URL = BASE_URL + 'service/address/searchCityOrZipcode/{cityOrZipcode}';
export const SEARCH_NEARBY = 'SEARCH_NEARBY';
export const SEARCH_CITY_ZIPCODE = 'SEARCH_CITY_ZIPCODE';
