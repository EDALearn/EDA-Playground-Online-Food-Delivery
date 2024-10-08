import path from 'path';
import url from 'url';

const __dirname = path.dirname(url.fileURLToPath(import.meta.url));

/** @type {import('@eventcatalog/core/bin/eventcatalog.config').Config} */
export default {
  title: 'EventCatalog',
  tagline: 'Discover, Explore and Document your Event Driven Architectures',
  organizationName: 'ZenWave 360',
  homepageLink: 'https://eventcatalog.dev/',
  editUrl: 'https://github.com/boyney123/eventcatalog-demo/edit/master',
  // By default set to false, add true to get urls ending in /
  trailingSlash: false,
  // Change to make the base url of the site different, by default https://{website}.com/docs,
  // changing to /company would be https://{website}.com/company/docs,
  base: '/EDA-Playground-Online-Food-Delivery/',
  // Customize the logo, add your logo to public/ folder
  logo: {
    alt: 'EventCatalog Logo',
    src: '/logo.png',
    text: 'EventCatalog'
  },
  docs: {
    sidebar: {
      // Should the sub heading be rendered in the docs sidebar?
      showPageHeadings: true
    }
  },
  // required random generated id used by eventcatalog
  cId: 'ddad72db-f9da-407d-9cb6-376a1cc53cde',
  generators: [
    // Add single AsyncAPI file to a domain
    [
      '@eventcatalog/generator-asyncapi',
      {
        services: [
          { path: path.win32.join(__dirname, '../modules/orders/src/main/resources/apis/asyncapi.yml'), id: 'orders'},
          { path: path.win32.join(__dirname, '../modules/customers/src/main/resources/apis/asyncapi.yml'), id: 'customers'},
          { path: path.win32.join(__dirname, '../modules/restaurants/src/main/resources/apis/asyncapi.yml'), id: 'restaurants'},
          { path: path.win32.join(__dirname, '../modules/delivery/src/main/resources/apis/asyncapi.yml'), id: 'delivery'},
        ],
        domain: { id: 'online-food-delivery', name: 'Online Food Delivery', version: '0.0.1' },

        // Run in debug mode, for extra output, if your AsyncAPI fails to parse, it will tell you why
        debug: true
      },
    ],
    // Add single OpenAPI file to a domain
    [
      '@eventcatalog/generator-openapi',
      {
        services: [
          { path: path.win32.join(__dirname, '../modules/orders/src/main/resources/apis/openapi.yml'), id: 'orders'},
          { path: path.win32.join(__dirname, '../modules/customers/src/main/resources/apis/openapi.yml'), id: 'customers'},
          { path: path.win32.join(__dirname, '../modules/restaurants/src/main/resources/apis/openapi.yml'), id: 'restaurants'},
          { path: path.win32.join(__dirname, '../modules/delivery/src/main/resources/apis/openapi.yml'), id: 'delivery'},
        ],
        domain: { id: 'online-food-delivery', name: 'Online Food Delivery', version: '0.0.1' },

        // Run in debug mode, for extra output, if your AsyncAPI fails to parse, it will tell you why
        debug: true
      },
    ],
  ]
}
