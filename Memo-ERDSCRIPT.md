# DrawSQL Background Replace
[DrawSQL](https://drawsql.app)

```javascript
(() => {
    let color = '#FFFFFF';
    document.querySelectorAll('rect[width="1"][height="1"]').forEach((element) => { element.setAttribute('fill',color); });
    document.querySelectorAll('div[class="joint-paper-scroller joint-theme-modern"]').forEach((element) => { element.setAttribute('style',`background-color: ${color} !important`); });
})
```
