import"./hoisted.B_PfRMJt.js";import{s as T,n as h}from"./router.1CaIavWq.js";function y(){const e=document.getElementById("visualiser-navigation"),t=document.getElementById("fullscreen-toggle"),n=document.getElementById("eventcatalog-header"),o=document.getElementById("eventcatalog-header-spacer");let r=!0;if(!e||!t)return;function a(){r=!r,e&&(e.style.display=r?"block":"none"),n&&(n.style.display=r?"block":"none"),o&&(o.style.display=r?"block":"none")}t.removeEventListener("click",a),t.addEventListener("click",a)}y();document.addEventListener("astro:page-load",y);const b=new Set,s=new WeakSet;let f,E,p=!1;function A(e){p||(p=!0,f??=e?.prefetchAll,E??=e?.defaultStrategy??"hover",k(),H(),B(),M())}function k(){for(const e of["touchstart","mousedown"])document.body.addEventListener(e,t=>{i(t.target,"tap")&&l(t.target.href,{ignoreSlowConnection:!0})},{passive:!0})}function H(){let e;document.body.addEventListener("focusin",o=>{i(o.target,"hover")&&t(o)},{passive:!0}),document.body.addEventListener("focusout",n,{passive:!0}),u(()=>{for(const o of document.getElementsByTagName("a"))s.has(o)||i(o,"hover")&&(s.add(o),o.addEventListener("mouseenter",t,{passive:!0}),o.addEventListener("mouseleave",n,{passive:!0}))});function t(o){const r=o.target.href;e&&clearTimeout(e),e=setTimeout(()=>{l(r)},80)}function n(){e&&(clearTimeout(e),e=0)}}function B(){let e;u(()=>{for(const t of document.getElementsByTagName("a"))s.has(t)||i(t,"viewport")&&(s.add(t),e??=I(),e.observe(t))})}function I(){const e=new WeakMap;return new IntersectionObserver((t,n)=>{for(const o of t){const r=o.target,a=e.get(r);o.isIntersecting?(a&&clearTimeout(a),e.set(r,setTimeout(()=>{n.unobserve(r),e.delete(r),l(r.href)},300))):a&&(clearTimeout(a),e.delete(r))}})}function M(){u(()=>{for(const e of document.getElementsByTagName("a"))i(e,"load")&&l(e.href)})}function l(e,t){e=e.replace(/#.*/,"");const n=t?.ignoreSlowConnection??!1;if(R(e,n))if(b.add(e),document.createElement("link").relList?.supports?.("prefetch")&&t?.with!=="fetch"){const o=document.createElement("link");o.rel="prefetch",o.setAttribute("href",e),document.head.append(o)}else fetch(e,{priority:"low"})}function R(e,t){if(!navigator.onLine||!t&&L())return!1;try{const n=new URL(e,location.href);return location.origin===n.origin&&(location.pathname!==n.pathname||location.search!==n.search)&&!b.has(e)}catch{}return!1}function i(e,t){if(e?.tagName!=="A")return!1;const n=e.dataset.astroPrefetch;return n==="false"?!1:t==="tap"&&(n!=null||f)&&L()?!0:n==null&&f||n===""?t===E:n===t}function L(){if("connection"in navigator){const e=navigator.connection;return e.saveData||/2g/.test(e.effectiveType)}return!1}function u(e){e();let t=!1;document.addEventListener("astro:page-load",()=>{if(!t){t=!0;return}e()})}function V(){const e=document.querySelector('[name="astro-view-transitions-fallback"]');return e?e.getAttribute("content"):"animate"}function v(e){return e.dataset.astroReload!==void 0}(T||V()!=="none")&&(document.addEventListener("click",e=>{let t=e.target;if(e.composed&&(t=e.composedPath()[0]),t instanceof Element&&(t=t.closest("a, area")),!(t instanceof HTMLAnchorElement)&&!(t instanceof SVGAElement)&&!(t instanceof HTMLAreaElement))return;const n=t instanceof HTMLElement?t.target:t.target.baseVal,o=t instanceof HTMLElement?t.href:t.href.baseVal,r=new URL(o,location.href).origin;v(t)||t.hasAttribute("download")||!t.href||n&&n!=="_self"||r!==location.origin||e.button!==0||e.metaKey||e.ctrlKey||e.altKey||e.shiftKey||e.defaultPrevented||(e.preventDefault(),h(o,{history:t.dataset.astroHistory==="replace"?"replace":"auto",sourceElement:t}))}),document.addEventListener("submit",e=>{let t=e.target;if(t.tagName!=="FORM"||e.defaultPrevented||v(t))return;const n=t,o=e.submitter,r=new FormData(n,o),a=typeof n.action=="string"?n.action:n.getAttribute("action"),w=typeof n.method=="string"?n.method:n.getAttribute("method");let c=o?.getAttribute("formaction")??a??location.pathname;const d=o?.getAttribute("formmethod")??w??"get";if(d==="dialog"||location.origin!==new URL(c,location.href).origin)return;const m={sourceElement:o??n};if(d==="get"){const S=new URLSearchParams(r),g=new URL(c);g.search=S.toString(),c=g.toString()}else m.formData=r;e.preventDefault(),h(c,m)}),A({prefetchAll:!0}));
