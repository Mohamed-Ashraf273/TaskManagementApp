| Storage Option | Data Type         | Capacity Limit | ACID Support | Backup Difficulty | Example in App                                      |
|----------------|------------------|----------------|--------------|------------------|-----------------------------------------------------|
| Files          | Unstructured (images, PDFs) | Limited by disk | No           | Medium           | Store task attachments (images, PDFs)               |
| DataStore      | Key-Value / small structured | MBs scale       | No           | Easy             | Store user preferences (e.g., dark mode)            |
| Room (SQLite)  | Structured tables | GBs scale      | Yes          | Easy             | Store Users, Projects, Tasks, and Attachments       |
