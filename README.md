# arc-text-extract-plugin

Note: this plugin has not been published yet. It works but requires further unit / integration tests and docs before being released.

Contains UDFs for extracting text from documents using [Apache Tika](https://tika.apache.org/)

```sql

select parseText(raw_doc_binary) as doc_text from docs

```